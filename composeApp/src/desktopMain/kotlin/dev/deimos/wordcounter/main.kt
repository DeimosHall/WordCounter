package dev.deimos.wordcounter

import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.jetbrains.compose.resources.painterResource
import wordcounter.composeapp.generated.resources.Res
import wordcounter.composeapp.generated.resources.icon

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Word Counter",
        icon = painterResource(Res.drawable.icon),
        state = rememberWindowState(
            position = WindowPosition.Aligned(Alignment.Center),
            size = DpSize(1000.dp, 700.dp)
        )
    ) {
        App(false)
    }
}