package com.example.audio

import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import com.example.model.Hymn
import com.example.model.NoteTone
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.math.PI
import kotlin.math.sin

class HymnAudioSynthesizer {

  private val sampleRate = 44100
  private var audioTrack: AudioTrack? = null
  private var playbackJob: Job? = null
  private val scope = CoroutineScope(Dispatchers.Default)

  private val _isPlaying = MutableStateFlow(false)
  val isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()

  private val _currentHymnNumber = MutableStateFlow<Int?>(null)
  val currentHymnNumber: StateFlow<Int?> = _currentHymnNumber.asStateFlow()

  private val _progress = MutableStateFlow(0f)
  val progress: StateFlow<Float> = _progress.asStateFlow()

  private var speedMultiplier = 1.0f

  fun setPlaybackSpeed(speed: Float) {
    speedMultiplier = speed.coerceIn(0.7f, 1.5f)
  }

  fun playHymn(hymn: Hymn) {
    stop()
    _currentHymnNumber.value = hymn.number
    _isPlaying.value = true
    _progress.value = 0f

    val notes = if (hymn.melodyNotes.isNotEmpty()) hymn.melodyNotes else generateFallbackMelody(hymn.number)

    playbackJob = scope.launch {
      try {
        val minBufferSize = AudioTrack.getMinBufferSize(
          sampleRate,
          AudioFormat.CHANNEL_OUT_MONO,
          AudioFormat.ENCODING_PCM_16BIT
        )

        audioTrack = AudioTrack.Builder()
          .setAudioAttributes(
            AudioAttributes.Builder()
              .setUsage(AudioAttributes.USAGE_MEDIA)
              .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
              .build()
          )
          .setAudioFormat(
            AudioFormat.Builder()
              .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
              .setSampleRate(sampleRate)
              .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
              .build()
          )
          .setBufferSizeInBytes(minBufferSize * 2)
          .setTransferMode(AudioTrack.MODE_STREAM)
          .build()

        audioTrack?.play()

        val totalNotes = notes.size
        for ((index, note) in notes.withIndex()) {
          if (!isActive || !_isPlaying.value) break

          val effectiveDuration = (note.durationMs / speedMultiplier).toInt()
          playNote(note.frequencyHz, effectiveDuration, note.isRest)
          _progress.value = (index + 1).toFloat() / totalNotes

          // Subtle natural breathing gap between notes
          delay(20)
        }
      } catch (e: Exception) {
        // Safe catch on playback interruption
      } finally {
        stop()
      }
    }
  }

  private fun playNote(frequency: Float, durationMs: Int, isRest: Boolean) {
    val track = audioTrack ?: return
    val numSamples = (sampleRate * (durationMs / 1000.0)).toInt().coerceAtLeast(100)
    val buffer = ShortArray(numSamples)

    if (isRest || frequency <= 0f) {
      // Silence
      buffer.fill(0)
    } else {
      val attackSamples = (sampleRate * 0.03).toInt() // 30ms smooth attack
      val releaseSamples = (sampleRate * 0.04).toInt() // 40ms smooth release

      for (i in 0 until numSamples) {
        val time = i.toDouble() / sampleRate
        // Sacred pipe organ synthesis: fundamental + subtle warm harmonics
        val wave1 = sin(2.0 * PI * frequency * time)
        val wave2 = 0.5 * sin(2.0 * PI * (frequency * 2) * time) // octave
        val wave3 = 0.25 * sin(2.0 * PI * (frequency * 3) * time) // fifth above
        val combined = (wave1 + wave2 + wave3) / 1.75

        // Envelope shaping to prevent clipping clicks
        var envelope = 1.0
        if (i < attackSamples) {
          envelope = i.toDouble() / attackSamples
        } else if (i > numSamples - releaseSamples) {
          envelope = (numSamples - i).toDouble() / releaseSamples
        }

        buffer[i] = (combined * envelope * Short.MAX_VALUE * 0.75).toInt().toShort()
      }
    }

    track.write(buffer, 0, buffer.size)
  }

  fun pause() {
    _isPlaying.value = false
    playbackJob?.cancel()
    playbackJob = null
    try {
      audioTrack?.pause()
    } catch (_: Exception) {}
  }

  fun stop() {
    _isPlaying.value = false
    playbackJob?.cancel()
    playbackJob = null
    _progress.value = 0f
    try {
      audioTrack?.stop()
      audioTrack?.release()
    } catch (_: Exception) {}
    audioTrack = null
  }

  private fun generateFallbackMelody(seedNumber: Int): List<NoteTone> {
    val baseScale = listOf(261.63f, 293.66f, 329.63f, 349.23f, 392.00f, 440.00f, 523.25f)
    val list = mutableListOf<NoteTone>()
    for (i in 0..15) {
      val noteIndex = (seedNumber + i * 3) % baseScale.size
      val freq = baseScale[noteIndex]
      val duration = if (i % 4 == 3) 800 else 450
      list.add(NoteTone(freq, duration))
    }
    return list
  }
}
