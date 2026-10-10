package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
  primary = BibleNavyPrimary,
  onPrimary = Color.White,
  primaryContainer = BibleGoldLight,
  onPrimaryContainer = BibleNavyDark,
  secondary = BibleGold,
  onSecondary = Color.White,
  secondaryContainer = BibleGoldLight,
  onSecondaryContainer = BibleGoldDark,
  tertiary = SacredBurgundy,
  onTertiary = Color.White,
  tertiaryContainer = SacredBurgundyLight,
  onTertiaryContainer = SacredBurgundy,
  background = WarmCreamBackground,
  onBackground = TextPrimaryDark,
  surface = WarmSurface,
  onSurface = TextPrimaryDark,
  surfaceVariant = WarmSurfaceVariant,
  onSurfaceVariant = TextSecondaryDark,
  error = ErrorRed,
  onError = Color.White
)

private val DarkColorScheme = darkColorScheme(
  primary = DarkPrimary,
  onPrimary = BibleNavyDark,
  primaryContainer = BibleNavyLight,
  onPrimaryContainer = Color.White,
  secondary = DarkSecondary,
  onSecondary = BibleNavyDark,
  secondaryContainer = DarkSurfaceVariant,
  onSecondaryContainer = DarkSecondary,
  tertiary = BibleGoldLight,
  onTertiary = BibleNavyDark,
  background = DarkBackground,
  onBackground = Color(0xFFE2E8F0),
  surface = DarkSurface,
  onSurface = Color(0xFFE2E8F0),
  surfaceVariant = DarkSurfaceVariant,
  onSurfaceVariant = Color(0xFFCBD5E1),
  error = Color(0xFFEF5350),
  onError = Color.Black
)

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicColor: Boolean = false, // Keep intentional sacred styling by default
  content: @Composable () -> Unit,
) {
  val colorScheme = when {
    dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
      val context = LocalContext.current
      if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }
    darkTheme -> DarkColorScheme
    else -> LightColorScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    content = content
  )
}
