package dev.deimos.wordcounter.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import dev.deimos.wordcounter.getPlatform

@Composable
fun WordCounterTheme(
    content: @Composable () -> Unit
) {
    val platform = getPlatform().name
    val dimensions = if (platform.startsWith("Android")) {
        AppDimensions(cardPadding = 30.dp)
    } else {
        AppDimensions(cardPadding = 15.dp)
    }

    CompositionLocalProvider(LocalAppDimensions provides dimensions) {
        MaterialTheme(
            content = content
        )
    }
}
