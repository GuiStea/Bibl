package com.example.model

enum class HymnCategory(val label: String) {
  TODOS("Todos os Hinos"),
  LOUVOR_E_ADORACAO("Louvor e Adoração"),
  SUPLICACAO_E_ORACAO("Suplicação e Oração"),
  CONSOLACAO("Consolação e Fé"),
  JOVENS_E_MENORES("Jovens e Menores"),
  SANTA_CEIA("Santa Ceia"),
  BATISMO("Batismo"),
  FUNERAL("Funeral / Esperança")
}

data class HymnVerse(
  val number: Int,
  val text: String,
  val isChorus: Boolean = false
)

data class NoteTone(
  val frequencyHz: Float,
  val durationMs: Int,
  val isRest: Boolean = false
)

data class Hymn(
  val number: Int,
  val title: String,
  val verses: List<HymnVerse>,
  val chorus: String? = null,
  val category: HymnCategory,
  val tonality: String,
  val tempoBpm: Int = 84,
  val timeSignature: String = "4/4",
  val melodyNotes: List<NoteTone> = emptyList(),
  val isFavorite: Boolean = false
) {
  val fullSearchableText: String
    get() = buildString {
      append(number)
      append(" ")
      append(title)
      append(" ")
      append(category.label)
      verses.forEach { append(" ").append(it.text) }
      chorus?.let { append(" ").append(it) }
    }
}
