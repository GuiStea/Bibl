package com.example.data

import com.example.model.QuizCategory
import com.example.model.QuizDifficulty
import com.example.model.QuizQuestion

object QuizRepository {
  val all200Questions: List<QuizQuestion> by lazy {
    QuizQuestionsPart1.questions + QuizQuestionsPart2.questions
  }

  fun getQuestionsForQuiz(
    difficulty: QuizDifficulty = QuizDifficulty.TODAS,
    category: QuizCategory = QuizCategory.TODAS,
    count: Int = 10
  ): List<QuizQuestion> {
    val filtered = all200Questions.filter { question ->
      val matchesDifficulty = when (difficulty) {
        QuizDifficulty.TODAS -> true
        else -> question.difficulty == difficulty
      }
      val matchesCategory = when (category) {
        QuizCategory.TODAS -> true
        else -> question.category == category
      }
      matchesDifficulty && matchesCategory
    }

    val pool = if (filtered.size >= count) filtered else all200Questions
    return pool.shuffled().take(count)
  }

  fun countByDifficulty(difficulty: QuizDifficulty): Int {
    return if (difficulty == QuizDifficulty.TODAS) {
      all200Questions.size
    } else {
      all200Questions.count { it.difficulty == difficulty }
    }
  }
}
