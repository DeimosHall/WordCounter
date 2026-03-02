package dev.deimos.wordcounter

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.deimos.wordcounter.ui.components.AreaTextField
import dev.deimos.wordcounter.ui.components.StatCard
import dev.deimos.wordcounter.ui.screens.WordCounterScreen
import dev.deimos.wordcounter.ui.theme.LocalAppDimensions
import dev.deimos.wordcounter.ui.theme.WordCounterTheme
import dev.deimos.wordcounter.ui.viewmodel.WordCounterViewModel
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import wordcounter.composeapp.generated.resources.Res
import wordcounter.composeapp.generated.resources.app_name
import wordcounter.composeapp.generated.resources.characters
import wordcounter.composeapp.generated.resources.clear_button
import wordcounter.composeapp.generated.resources.lines
import wordcounter.composeapp.generated.resources.stats
import wordcounter.composeapp.generated.resources.text_input
import wordcounter.composeapp.generated.resources.text_input_hint
import wordcounter.composeapp.generated.resources.words

@Composable
@Preview
fun App(renderTitle: Boolean = true) {
    WordCounterTheme {
        val viewModel = viewModel { WordCounterViewModel() }
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        WordCounterScreen(
            renderTitle,
            uiState,
            onTextChange = { newText -> viewModel.updateText(newText) },
            onClearRequested = { viewModel.clear() }
        )
    }
}
