package com.example.model

enum class DevotionalCategory(val title: String, val iconName: String) {
  PAZ("Paz & Serenidade", "spa"),
  FE("Fé Inabalável", "favorite"),
  ESPERANCA("Esperança", "wb_sunny"),
  GRATIDAO("Gratidão & Louvor", "volunteer_activism"),
  SABEDORIA("Sabedoria & Direção", "lightbulb"),
  ORACAO("Oração & Comunhão", "self_improvement"),
  CONSOLO("Consolo nas Provações", "shield"),
  AMOR("Amor ao Próximo", "favorite_border"),
  VITORIA("Superação & Vitória", "military_tech")
}

data class Devotional(
  val id: Int,
  val dayOfYear: Int,
  val title: String,
  val category: DevotionalCategory,
  val keyVerseText: String,
  val keyVerseReference: String,
  val reflectionParagraphs: List<String>,
  val guidedPrayer: String,
  val practicalAction: String,
  val isFavorite: Boolean = false,
  val isRead: Boolean = false
)
