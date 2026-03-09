package dev.deimos.wordcounter.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.deimos.wordcounter.getPlatform

private val Teal200 = Color(0xFF80CBC4)
private val Teal500 = Color(0xFF009688)
private val Teal700 = Color(0xFF00796B)

private val Dark = Color(0xff1d1d20)

private val Light = Color(0xffffffff)

private val DarkColorScheme = darkColorScheme(
    primary = Teal200,
    secondary = Teal200,
    tertiary = Teal700,
    background = Dark
)

private val LightColorScheme = lightColorScheme(
    primary = Teal500,
    secondary = Teal500,
    tertiary = Teal700,
    background = Light
)

@Composable
fun WordCounterTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val platform = getPlatform().name
    val dimensions = if (platform.startsWith("Android")) {
        AppDimensions(
            cardPadding = 30.dp,
            buttonCornerRadius = 12.dp
        )
    } else {
        AppDimensions(
            cardPadding = 15.dp,
            buttonCornerRadius = 8.dp
        )
    }

    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    CompositionLocalProvider(LocalAppDimensions provides dimensions) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}
