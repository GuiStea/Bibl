package com.example.util

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.*
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.widget.Toast
import androidx.core.content.FileProvider
import com.example.model.BlessingCard
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

object BlessingImageGenerator {

  fun generateCompositeBitmap(context: Context, card: BlessingCard): Bitmap {
    val targetWidth = 1080
    val targetHeight = 1080

    val compositeBitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(compositeBitmap)

    // 1. Decode original background image
    val options = BitmapFactory.Options().apply { inPreferredConfig = Bitmap.Config.ARGB_8888 }
    val originalBitmap = BitmapFactory.decodeResource(context.resources, card.imageResId, options)

    // 2. Draw scaled background image to fill target square/rectangle
    if (originalBitmap != null) {
      val srcRect = Rect(0, 0, originalBitmap.width, originalBitmap.height)
      val destRect = Rect(0, 0, targetWidth, targetHeight)
      val paint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG)
      canvas.drawBitmap(originalBitmap, srcRect, destRect, paint)
    } else {
      // Fallback background
      canvas.drawColor(Color.parseColor("#1E3A5F"))
    }

    // 3. Draw gradient scrim for high readability
    val scrimPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    val scrimGradient = LinearGradient(
      0f, 0f, 0f, targetHeight.toFloat(),
      intArrayOf(
        Color.argb(120, 0, 0, 0),
        Color.argb(40, 0, 0, 0),
        Color.argb(160, 0, 0, 0),
        Color.argb(235, 10, 15, 25)
      ),
      floatArrayOf(0f, 0.25f, 0.55f, 1.0f),
      Shader.TileMode.CLAMP
    )
    scrimPaint.shader = scrimGradient
    canvas.drawRect(0f, 0f, targetWidth.toFloat(), targetHeight.toFloat(), scrimPaint)

    // 4. Draw Header Badge (Category Pill)
    val badgePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
      color = Color.parseColor("#E0D49B27") // Golden accent
      style = Paint.Style.FILL
    }
    val badgeTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
      color = Color.WHITE
      textSize = 34f
      typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
      textAlign = Paint.Align.CENTER
    }

    val badgeText = card.category.label.uppercase()
    val badgeWidth = badgeTextPaint.measureText(badgeText) + 70f
    val badgeHeight = 58f
    val badgeLeft = 60f
    val badgeTop = 60f
    val badgeRect = RectF(badgeLeft, badgeTop, badgeLeft + badgeWidth, badgeTop + badgeHeight)
    canvas.drawRoundRect(badgeRect, 29f, 29f, badgePaint)
    canvas.drawText(badgeText, badgeRect.centerX(), badgeRect.centerY() + 12f, badgeTextPaint)

    // 5. Draw Greeting Text (Large Bold)
    val greetingPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
      color = Color.WHITE
      textSize = 52f
      typeface = Typeface.create(Typeface.SERIF, Typeface.BOLD)
      setShadowLayer(8f, 2f, 4f, Color.argb(180, 0, 0, 0))
    }

    val marginHorizontal = 70
    val textWidth = targetWidth - (marginHorizontal * 2)

    val greetingLayout = StaticLayout.Builder.obtain(
      card.greeting, 0, card.greeting.length, greetingPaint, textWidth
    ).setAlignment(Layout.Alignment.ALIGN_NORMAL).build()

    val greetingY = targetHeight - 480f
    canvas.save()
    canvas.translate(marginHorizontal.toFloat(), greetingY)
    greetingLayout.draw(canvas)
    canvas.restore()

    // 6. Draw Golden Decorative Divider
    val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
      color = Color.parseColor("#F5C344")
      strokeWidth = 3f
      style = Paint.Style.STROKE
    }
    val lineY = greetingY + greetingLayout.height + 25f
    canvas.drawLine(marginHorizontal.toFloat(), lineY, (marginHorizontal + 160).toFloat(), lineY, linePaint)

    // 7. Draw Scripture Verse (Italic Medium)
    val versePaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
      color = Color.parseColor("#F5F5F5")
      textSize = 38f
      typeface = Typeface.create(Typeface.SERIF, Typeface.ITALIC)
      setShadowLayer(6f, 2f, 3f, Color.argb(160, 0, 0, 0))
    }

    val verseFormatted = "\"${card.scriptureVerse}\""
    val verseLayout = StaticLayout.Builder.obtain(
      verseFormatted, 0, verseFormatted.length, versePaint, textWidth
    ).setAlignment(Layout.Alignment.ALIGN_NORMAL).build()

    val verseY = lineY + 30f
    canvas.save()
    canvas.translate(marginHorizontal.toFloat(), verseY)
    verseLayout.draw(canvas)
    canvas.restore()

    // 8. Draw Reference (Golden Bold)
    val refPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
      color = Color.parseColor("#F5C344")
      textSize = 36f
      typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
      textAlign = Paint.Align.RIGHT
      setShadowLayer(4f, 1f, 2f, Color.argb(180, 0, 0, 0))
    }
    val refY = verseY + verseLayout.height + 45f
    canvas.drawText("— ${card.scriptureReference}", (targetWidth - marginHorizontal).toFloat(), refY, refPaint)

    // 9. Watermark footer
    val watermarkPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
      color = Color.argb(160, 255, 255, 255)
      textSize = 28f
      typeface = Typeface.DEFAULT
      textAlign = Paint.Align.LEFT
    }
    canvas.drawText("✨ Bíblia & Louvor", marginHorizontal.toFloat(), (targetHeight - 40).toFloat(), watermarkPaint)

    return compositeBitmap
  }

  fun saveBitmapToGallery(context: Context, bitmap: Bitmap, title: String): Boolean {
    val filename = "Bencao_${title.replace("[^a-zA-Z0-9]".toRegex(), "_")}_${System.currentTimeMillis()}.jpg"

    return try {
      val contentValues = ContentValues().apply {
        put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
        put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
          put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + "/BibliaELouvor")
          put(MediaStore.MediaColumns.IS_PENDING, 1)
        }
      }

      val resolver = context.contentResolver
      val uri: Uri? = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)

      if (uri != null) {
        val stream: OutputStream? = resolver.openOutputStream(uri)
        if (stream != null) {
          bitmap.compress(Bitmap.CompressFormat.JPEG, 95, stream)
          stream.flush()
          stream.close()
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
          contentValues.clear()
          contentValues.put(MediaStore.MediaColumns.IS_PENDING, 0)
          resolver.update(uri, contentValues, null, null)
        }

        Toast.makeText(context, "Foto salva na sua Galeria de Imagens! 📸✨", Toast.LENGTH_LONG).show()
        true
      } else {
        Toast.makeText(context, "Erro ao criar imagem na galeria.", Toast.LENGTH_SHORT).show()
        false
      }
    } catch (e: Exception) {
      e.printStackTrace()
      Toast.makeText(context, "Erro ao salvar foto: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
      false
    }
  }

  fun shareCompositeBitmap(context: Context, bitmap: Bitmap, card: BlessingCard) {
    try {
      val cacheDir = File(context.cacheDir, "images").apply { mkdirs() }
      val file = File(cacheDir, "bencao_compartilhar_${System.currentTimeMillis()}.jpg")
      val stream = FileOutputStream(file)
      bitmap.compress(Bitmap.CompressFormat.JPEG, 95, stream)
      stream.flush()
      stream.close()

      val uri: Uri = FileProvider.getUriForFile(
        context,
        "${context.packageName}.fileprovider",
        file
      )

      val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "image/jpeg"
        putExtra(Intent.EXTRA_STREAM, uri)
        putExtra(Intent.EXTRA_TEXT, "${card.greeting}\n\n\"${card.scriptureVerse}\" (${card.scriptureReference})\n\n✨ Bíblia & Louvor")
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
      }

      context.startActivity(Intent.createChooser(shareIntent, "Compartilhar Imagem com Mensagem"))
    } catch (e: Exception) {
      e.printStackTrace()
      // Fallback to text sharing
      val textIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, card.fullShareText)
      }
      context.startActivity(Intent.createChooser(textIntent, "Compartilhar Mensagem"))
    }
  }
}
