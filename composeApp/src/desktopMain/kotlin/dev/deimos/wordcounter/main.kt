package dev.deimos.wordcounter

import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Word Counter",
        state = rememberWindowState(
            position = WindowPosition.Aligned(Alignment.Center),
            size = DpSize(1000.dp, 700.dp)
        )
    ) {
        App(false)
        println("System Locale: ${java.util.Locale.getDefault()}")
        println("Language: ${java.util.Locale.getDefault().language}")
    }
}