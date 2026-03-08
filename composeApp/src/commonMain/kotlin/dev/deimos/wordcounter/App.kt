package dev.deimos.wordcounter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.deimos.wordcounter.ui.screens.AboutScreen
import dev.deimos.wordcounter.ui.screens.WordCounterScreen
import dev.deimos.wordcounter.ui.theme.WordCounterTheme
import dev.deimos.wordcounter.ui.viewmodel.WordCounterViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(renderTitle: Boolean = true) {
    WordCounterTheme {
        val viewModel = viewModel { WordCounterViewModel() }
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                Column(modifier = Modifier.fillMaxSize()) {
                    WordCounterScreen(
                        renderTitle,
                        uiState,
                        onTextChange = { newText -> viewModel.updateText(newText) },
                        onClearRequested = { viewModel.clear() },
                        onAboutClick = { navController.navigate("about") }
                    )
                }
            }

            composable("about") {
                AboutScreen(onNavigateBack = { navController.navigate("home") })
            }
        }
    }
}
