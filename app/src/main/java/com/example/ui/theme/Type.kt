package com.example.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.R

val CinzelFontFamily = FontFamily(
  Font(R.font.cinzel, FontWeight.Normal),
  Font(R.font.cinzel, FontWeight.Bold)
)

val LoraFontFamily = FontFamily(
  Font(R.font.lora, FontWeight.Normal),
  Font(R.font.lora, FontWeight.Bold)
)

val Typography = Typography(
  displayLarge = TextStyle(
    fontFamily = CinzelFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 32.sp,
    lineHeight = 38.sp,
    letterSpacing = 0.5.sp
  ),
  headlineLarge = TextStyle(
    fontFamily = CinzelFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 26.sp,
    lineHeight = 32.sp,
    letterSpacing = 0.25.sp
  ),
  headlineMedium = TextStyle(
    fontFamily = CinzelFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 22.sp,
    lineHeight = 28.sp
  ),
  titleLarge = TextStyle(
    fontFamily = CinzelFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
    lineHeight = 26.sp
  ),
  titleMedium = TextStyle(
    fontFamily = CinzelFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 17.sp,
    lineHeight = 24.sp
  ),
  bodyLarge = TextStyle(
    fontFamily = LoraFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.3.sp
  ),
  bodyMedium = TextStyle(
    fontFamily = LoraFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.25.sp
  ),
  labelLarge = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.SemiBold,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.5.sp
  )
)
