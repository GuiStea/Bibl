package com.example.model

enum class BlessingCategory(val label: String) {
  TODAS("Todas as Fotos"),
  BOM_DIA("Bom Dia ☀️"),
  BOA_TARDE("Boa Tarde 🌤️"),
  BOA_NOITE("Boa Noite 🌙"),
  DURMA_COM_DEUS("Durma com Deus ✨"),
  PAZ_E_GRATIDAO("Paz & Bênção 🌿")
}

data class BlessingCard(
  val id: Int,
  val title: String,
  val greeting: String,
  val scriptureVerse: String,
  val scriptureReference: String,
  val imageResId: Int,
  val category: BlessingCategory
) {
  val fullShareText: String
    get() = buildString {
      append(greeting).append("\n\n")
      append("\"").append(scriptureVerse).append("\"\n")
      append("— ").append(scriptureReference).append("\n\n")
      append("Que Deus abençoe abundantemente o seu dia!")
    }
}
