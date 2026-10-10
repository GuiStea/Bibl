package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.DevotionalsData
import com.example.data.HymnsData
import com.example.data.QuizRepository
import com.example.model.QuizDifficulty
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("Bíblia & Louvor", appName)
  }

  @Test
  fun `verify total quiz questions count is exactly 200`() {
    val questions = QuizRepository.all200Questions
    assertEquals(200, questions.size)
  }

  @Test
  fun `verify each quiz round samples exactly 10 questions`() {
    val roundQuestions = QuizRepository.getQuestionsForQuiz(difficulty = QuizDifficulty.TODAS, count = 10)
    assertEquals(10, roundQuestions.size)
  }

  @Test
  fun `verify hymn search works by number and title`() {
    val hymn131 = HymnsData.getHymnByNumber(131)
    assertNotNull(hymn131)
    assertEquals("Ó Senhor bendito", hymn131?.title)

    val searchResults = HymnsData.searchHymns("Pastor")
    assertTrue(searchResults.isNotEmpty())
  }

  @Test
  fun `verify devotional data availability`() {
    val today = DevotionalsData.getTodayDevotional()
    assertNotNull(today)
    assertTrue(today.keyVerseText.isNotEmpty())
    assertTrue(today.guidedPrayer.isNotEmpty())
  }

  @Test
  fun `verify blessing cards categories exist and have items`() {
    val allCards = com.example.data.BlessingCardsData.cardsList
    assertTrue(allCards.isNotEmpty())

    val bomDiaCards = com.example.data.BlessingCardsData.getByCategory(com.example.model.BlessingCategory.BOM_DIA)
    assertTrue(bomDiaCards.isNotEmpty())

    val boaNoiteCards = com.example.data.BlessingCardsData.getByCategory(com.example.model.BlessingCategory.BOA_NOITE)
    assertTrue(boaNoiteCards.isNotEmpty())

    val durmaCards = com.example.data.BlessingCardsData.getByCategory(com.example.model.BlessingCategory.DURMA_COM_DEUS)
    assertTrue(durmaCards.isNotEmpty())
  }
}
