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
import dev.deimos.wordcounter.ui.components.AreaTextField
import dev.deimos.wordcounter.ui.components.StatCard
import dev.deimos.wordcounter.ui.theme.LocalAppDimensions
import dev.deimos.wordcounter.ui.theme.WordCounterTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(renderTitle: Boolean = true) {
    fun getWordsCounting(text: String): Int {
        return text.split(Regex("\\s+")).filter { it.isNotBlank() }.size
    }

    fun getLinesCounting(text: String): Int {
        return text.split(Regex("\\r?\\n")).filter { it.isNotBlank() }.size
    }

    WordCounterTheme {
        var textState by rememberSaveable() { mutableStateOf("") }
        val scrollState = rememberScrollState()

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
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
                    if (renderTitle) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = "Word Counter",
                                fontSize = 25.sp,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .verticalScroll(scrollState)
                    ) {
                        Text(
                            text = "Text Input",
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        AreaTextField(
                            value = textState,
                            onValueChanged = { textState = it },
                            hintText = "Text",
                        )
                        Text(
                            text = "Stats",
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
                                    "Characters",
                                    textState.length.toString(),
                                    modifier = Modifier.weight(1f)
                                )
                                StatCard(
                                    "Words",
                                    getWordsCounting(textState).toString(),
                                    modifier = Modifier.weight(1f)
                                )
                            }
                            StatCard(
                                "Lines",
                                getLinesCounting(textState).toString(),
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                    Button(
                        onClick = { textState = "" },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(LocalAppDimensions.current.buttonCornerRadius)
                    ) {
                        Text("Clear")
                    }
                }
            }
        }
    }
}
