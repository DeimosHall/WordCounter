package dev.deimos.wordcounter.ui.theme

import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AppDimensions(val cardPadding: Dp)

val LocalAppDimensions = staticCompositionLocalOf { AppDimensions(cardPadding = 30.dp) }