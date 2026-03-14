package dev.deimos.wordcounter.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.deimos.wordcounter.ui.components.InfoCard
import dev.deimos.wordcounter.ui.theme.WordCounterTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import wordcounter.composeapp.generated.resources.Res
import wordcounter.composeapp.generated.resources.about
import wordcounter.composeapp.generated.resources.author
import wordcounter.composeapp.generated.resources.icon
import wordcounter.composeapp.generated.resources.license

@Composable
fun AboutScreen(onNavigateBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        // TODO: Add this as a "desktop container" or something similar
        Column(
            modifier = Modifier
                .widthIn(max = 1000.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onNavigateBack,
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Go Back"
                    )
                }
                Text(stringResource(Res.string.about))
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .widthIn(max = 600.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Spacer(modifier = Modifier.height(64.dp))
                Image(
                    painterResource(Res.drawable.icon),
                    contentDescription = "",
                    modifier = Modifier.size(120.dp).clip(RoundedCornerShape(16.dp)),
                )
                Text(
                    text = "Word Counter",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                // TODO: wrap in a chip
                Text(text = "v0.1.0")
                InfoCard(stringResource(Res.string.author), "Deimos Hall")
                InfoCard(stringResource(Res.string.license), "GPLv3")
            }
        }
    }
}

@Preview
@Composable
fun AboutScreenPreview() {
    WordCounterTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            AboutScreen(onNavigateBack = {})
        }
    }
}