package com.example.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.audio.HymnAudioSynthesizer
import com.example.audio.TtsManager
import com.example.data.AppPreferences
import com.example.data.DevotionalsData
import com.example.data.HymnsData
import com.example.data.QuizRepository
import com.example.model.AnsweredQuestion
import com.example.model.BlessingCard
import com.example.model.BlessingCategory
import com.example.model.Devotional
import com.example.model.DevotionalCategory
import com.example.model.Hymn
import com.example.model.HymnCategory
import com.example.model.QuizCategory
import com.example.model.QuizDifficulty
import com.example.model.QuizSessionState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

enum class AppScreen {
  HOME,
  QUIZ,
  DEVOTIONAL,
  HYMNS,
  MESSAGES
}

class MainViewModel(application: Application) : AndroidViewModel(application) {

  val prefs = AppPreferences(application)
  val synthesizer = HymnAudioSynthesizer()
  val ttsManager = TtsManager(application)

  private val _currentScreen = MutableStateFlow(AppScreen.HOME)
  val currentScreen: StateFlow<AppScreen> = _currentScreen.asStateFlow()

  // --- QUIZ STATE ---
  private val _quizState = MutableStateFlow(QuizSessionState())
  val quizState: StateFlow<QuizSessionState> = _quizState.asStateFlow()

  private val _isQuizActive = MutableStateFlow(false)
  val isQuizActive: StateFlow<Boolean> = _isQuizActive.asStateFlow()

  // --- DEVOTIONAL STATE ---
  private val _selectedDevotional = MutableStateFlow(DevotionalsData.getTodayDevotional())
  val selectedDevotional: StateFlow<Devotional> = _selectedDevotional.asStateFlow()

  private val _selectedDevotionalTheme = MutableStateFlow<DevotionalCategory?>(null)
  val selectedDevotionalTheme: StateFlow<DevotionalCategory?> = _selectedDevotionalTheme.asStateFlow()

  private val _devotionalTextSize = MutableStateFlow(16) // sp
  val devotionalTextSize: StateFlow<Int> = _devotionalTextSize.asStateFlow()

  // --- HYMNS STATE ---
  private val _hymnSearchQuery = MutableStateFlow("")
  val hymnSearchQuery: StateFlow<String> = _hymnSearchQuery.asStateFlow()

  private val _selectedHymnCategory = MutableStateFlow(HymnCategory.TODOS)
  val selectedHymnCategory: StateFlow<HymnCategory> = _selectedHymnCategory.asStateFlow()

  private val _activeHymnDetail = MutableStateFlow<Hymn?>(null)
  val activeHymnDetail: StateFlow<Hymn?> = _activeHymnDetail.asStateFlow()

  private val _showOnlyFavoriteHymns = MutableStateFlow(false)
  val showOnlyFavoriteHymns: StateFlow<Boolean> = _showOnlyFavoriteHymns.asStateFlow()

  private val _hymnTextSize = MutableStateFlow(17) // sp
  val hymnTextSize: StateFlow<Int> = _hymnTextSize.asStateFlow()

  fun navigateTo(screen: AppScreen) {
    _currentScreen.value = screen
    if (screen != AppScreen.HYMNS) {
      synthesizer.stop()
    }
    if (screen != AppScreen.DEVOTIONAL && screen != AppScreen.HYMNS) {
      ttsManager.stop()
    }
  }

  // --- QUIZ ACTIONS ---
  fun startNewQuiz(
    difficulty: QuizDifficulty = _quizState.value.selectedDifficulty,
    category: QuizCategory = _quizState.value.selectedCategory
  ) {
    val tenQuestions = QuizRepository.getQuestionsForQuiz(difficulty, category, count = 10)
    _quizState.value = QuizSessionState(
      questions = tenQuestions,
      currentIndex = 0,
      selectedAnswerIndex = null,
      isAnswerSubmitted = false,
      correctAnswersCount = 0,
      currentStreak = 0,
      bestStreak = 0,
      answeredQuestions = emptyList(),
      isFinished = false,
      selectedDifficulty = difficulty,
      selectedCategory = category
    )
    _isQuizActive.value = true
  }

  fun selectAnswer(index: Int) {
    val state = _quizState.value
    if (state.isAnswerSubmitted || state.isFinished) return
    val currentQ = state.currentQuestion ?: return

    val isCorrect = (index == currentQ.correctOptionIndex)
    val newStreak = if (isCorrect) state.currentStreak + 1 else 0
    val newBestStreak = maxOf(state.bestStreak, newStreak)
    val newCorrectCount = if (isCorrect) state.correctAnswersCount + 1 else state.correctAnswersCount

    val answeredItem = AnsweredQuestion(
      question = currentQ,
      selectedIndex = index,
      isCorrect = isCorrect
    )

    _quizState.value = state.copy(
      selectedAnswerIndex = index,
      isAnswerSubmitted = true,
      correctAnswersCount = newCorrectCount,
      currentStreak = newStreak,
      bestStreak = newBestStreak,
      answeredQuestions = state.answeredQuestions + answeredItem
    )
  }

  fun nextQuestion() {
    val state = _quizState.value
    if (state.currentIndex + 1 < state.questions.size) {
      _quizState.value = state.copy(
        currentIndex = state.currentIndex + 1,
        selectedAnswerIndex = null,
        isAnswerSubmitted = false
      )
    } else {
      // Finished 10 questions round!
      _quizState.value = state.copy(isFinished = true)
      // Save stats
      prefs.totalQuizzesPlayed += 1
      prefs.totalCorrectAnswers += state.correctAnswersCount
      if (state.correctAnswersCount > prefs.bestScore) {
        prefs.bestScore = state.correctAnswersCount
      }
    }
  }

  fun exitQuiz() {
    _isQuizActive.value = false
  }

  // --- DEVOTIONAL ACTIONS ---
  fun selectDevotional(devotional: Devotional) {
    _selectedDevotional.value = devotional
    prefs.markDevotionalRead(devotional.id)
    ttsManager.stop()
  }

  fun filterDevotionalsByTheme(theme: DevotionalCategory?) {
    _selectedDevotionalTheme.value = theme
    if (theme != null) {
      val match = DevotionalsData.getByTheme(theme).firstOrNull()
      if (match != null) {
        _selectedDevotional.value = match
      }
    }
  }

  fun toggleDevotionalFavorite(id: Int): Boolean {
    val isFav = prefs.toggleDevotionalFavorite(id)
    val cur = _selectedDevotional.value
    if (cur.id == id) {
      _selectedDevotional.value = cur.copy(isFavorite = isFav)
    }
    return isFav
  }

  fun playDevotionalAudio(devotional: Devotional) {
    if (ttsManager.isSpeaking.value) {
      ttsManager.stop()
    } else {
      val textToRead = buildString {
        append(devotional.title).append(". ")
        append("Versículo Chave: ").append(devotional.keyVerseReference).append(". ")
        append(devotional.keyVerseText).append(". ")
        append("Reflexão: ")
        devotional.reflectionParagraphs.forEach { append(it).append(" ") }
        append("Oração do Dia: ").append(devotional.guidedPrayer)
      }
      ttsManager.speak(textToRead)
    }
  }

  fun adjustDevotionalTextSize(delta: Int) {
    val next = (_devotionalTextSize.value + delta).coerceIn(13, 24)
    _devotionalTextSize.value = next
  }

  // --- HYMNS ACTIONS ---
  fun setHymnSearchQuery(query: String) {
    _hymnSearchQuery.value = query
  }

  fun setHymnCategory(category: HymnCategory) {
    _selectedHymnCategory.value = category
  }

  fun toggleShowOnlyFavorites() {
    _showOnlyFavoriteHymns.value = !_showOnlyFavoriteHymns.value
  }

  fun openHymnDetail(hymn: Hymn) {
    _activeHymnDetail.value = hymn
  }

  fun closeHymnDetail() {
    _activeHymnDetail.value = null
    synthesizer.stop()
    ttsManager.stop()
  }

  fun toggleHymnFavorite(number: Int): Boolean {
    val isFav = prefs.toggleHymnFavorite(number)
    val cur = _activeHymnDetail.value
    if (cur?.number == number) {
      _activeHymnDetail.value = cur.copy(isFavorite = isFav)
    }
    return isFav
  }

  fun playHymnOrgan(hymn: Hymn) {
    ttsManager.stop()
    if (synthesizer.isPlaying.value && synthesizer.currentHymnNumber.value == hymn.number) {
      synthesizer.pause()
    } else {
      synthesizer.playHymn(hymn)
    }
  }

  fun reciteHymn(hymn: Hymn) {
    synthesizer.stop()
    if (ttsManager.isSpeaking.value) {
      ttsManager.stop()
    } else {
      val lyrics = buildString {
        append("Hino ").append(hymn.number).append(". ").append(hymn.title).append(". ")
        hymn.verses.forEach { verse ->
          append("Estrofe ").append(verse.number).append(": ").append(verse.text).append(". ")
          hymn.chorus?.let { append("Coro: ").append(it).append(". ") }
        }
      }
      ttsManager.speak(lyrics)
    }
  }

  fun adjustHymnTextSize(delta: Int) {
    val next = (_hymnTextSize.value + delta).coerceIn(14, 26)
    _hymnTextSize.value = next
  }

  // --- BLESSING & PHOTO MESSAGES STATE ---
  private val _selectedBlessingCategory = MutableStateFlow(BlessingCategory.TODAS)
  val selectedBlessingCategory: StateFlow<BlessingCategory> = _selectedBlessingCategory.asStateFlow()

  private val _activeBlessingCard = MutableStateFlow<BlessingCard?>(null)
  val activeBlessingCard: StateFlow<BlessingCard?> = _activeBlessingCard.asStateFlow()

  private val _showOnlyFavoriteBlessings = MutableStateFlow(false)
  val showOnlyFavoriteBlessings: StateFlow<Boolean> = _showOnlyFavoriteBlessings.asStateFlow()

  fun setBlessingCategory(category: BlessingCategory) {
    _selectedBlessingCategory.value = category
  }

  fun toggleShowOnlyFavoriteBlessings() {
    _showOnlyFavoriteBlessings.value = !_showOnlyFavoriteBlessings.value
  }

  fun openBlessingDetail(card: BlessingCard) {
    _activeBlessingCard.value = card
  }

  fun closeBlessingDetail() {
    _activeBlessingCard.value = null
  }

  fun toggleBlessingFavorite(id: Int): Boolean {
    return prefs.toggleBlessingFavorite(id)
  }

  override fun onCleared() {
    super.onCleared()
    synthesizer.stop()
    ttsManager.shutdown()
  }
}
