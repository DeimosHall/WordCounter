package dev.deimos.wordcounter.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.deimos.wordcounter.ui.components.AreaTextField
import dev.deimos.wordcounter.ui.components.StatCard
import dev.deimos.wordcounter.ui.components.TopHeader
import dev.deimos.wordcounter.ui.state.TextState
import dev.deimos.wordcounter.ui.theme.LocalAppDimensions
import org.jetbrains.compose.resources.stringResource
import wordcounter.composeapp.generated.resources.Res
import wordcounter.composeapp.generated.resources.characters
import wordcounter.composeapp.generated.resources.clear_button
import wordcounter.composeapp.generated.resources.lines
import wordcounter.composeapp.generated.resources.stats
import wordcounter.composeapp.generated.resources.text_input
import wordcounter.composeapp.generated.resources.text_input_hint
import wordcounter.composeapp.generated.resources.words

@Composable
fun WordCounterScreen(
    renderTitle: Boolean,
    textState: TextState,
    onTextChange: (String) -> Unit,
    onClearRequested: () -> Unit,
    onAboutClick: () -> Unit
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxHeight()
                .widthIn(max = 1000.dp)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TopHeader(renderTitle, onAboutClick)
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .verticalScroll(scrollState)
            ) {
                Text(
                    text = stringResource(Res.string.text_input),
                    color = MaterialTheme.colorScheme.onBackground
                )
                AreaTextField(
                    value = textState.text,
                    onValueChanged = onTextChange,
                    hintText = stringResource(Res.string.text_input_hint),
                )
                Text(
                    text = stringResource(Res.string.stats),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Column(
                    modifier = Modifier.fillMaxWidth().height(240.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        StatCard(
                            stringResource(Res.string.characters),
                            textState.charCount.toString(),
                            modifier = Modifier.weight(1f)
                        )
                        StatCard(
                            stringResource(Res.string.words),
                            textState.wordsCount.toString(),
                            modifier = Modifier.weight(1f)
                        )
                    }
                    StatCard(
                        stringResource(Res.string.lines),
                        textState.linesCount.toString(),
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            Button(
                onClick = onClearRequested,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(LocalAppDimensions.current.buttonCornerRadius)
            ) {
                Text(stringResource(Res.string.clear_button))
            }
        }
    }
}