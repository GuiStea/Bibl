package com.example.model

enum class QuizDifficulty(val label: String, val description: String) {
  TODAS("Todas", "Perguntas de todos os níveis sorteadas"),
  FACIL("Fácil", "Perguntas introdutórias e fundamentais"),
  MEDIO("Médio", "Conhecimento intermediário da Bíblia"),
  DIFICIL("Difícil", "Detalhes profundos e passagens históricas")
}

enum class QuizCategory(val label: String) {
  TODAS("Todas as Categorias"),
  ANTIGO_TESTAMENTO("Antigo Testamento"),
  NOVO_TESTAMENTO("Novo Testamento"),
  EVANGELHOS("Evangelhos"),
  PROFETAS("Profetas e Reis"),
  MILAGRES_E_PARABOLAS("Milagres e Parábolas"),
  PERSONAGENS("Personagens Bíblicos")
}

data class QuizQuestion(
  val id: Int,
  val question: String,
  val options: List<String>,
  val correctOptionIndex: Int,
  val biblicalReference: String,
  val explanation: String,
  val difficulty: QuizDifficulty,
  val category: QuizCategory
)

data class AnsweredQuestion(
  val question: QuizQuestion,
  val selectedIndex: Int,
  val isCorrect: Boolean
)

data class QuizSessionState(
  val questions: List<QuizQuestion> = emptyList(),
  val currentIndex: Int = 0,
  val selectedAnswerIndex: Int? = null,
  val isAnswerSubmitted: Boolean = false,
  val correctAnswersCount: Int = 0,
  val currentStreak: Int = 0,
  val bestStreak: Int = 0,
  val answeredQuestions: List<AnsweredQuestion> = emptyList(),
  val isFinished: Boolean = false,
  val selectedDifficulty: QuizDifficulty = QuizDifficulty.TODAS,
  val selectedCategory: QuizCategory = QuizCategory.TODAS
) {
  val currentQuestion: QuizQuestion?
    get() = if (currentIndex in questions.indices) questions[currentIndex] else null

  val progress: Float
    get() = if (questions.isNotEmpty()) (currentIndex + 1).toFloat() / questions.size else 0f
}
