package dev.deimos.wordcounter.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.deimos.wordcounter.ui.components.InfoCard
import dev.deimos.wordcounter.ui.theme.WordCounterTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import wordcounter.composeapp.generated.resources.Res
import wordcounter.composeapp.generated.resources.about
import wordcounter.composeapp.generated.resources.icon

@Composable
fun AboutScreen(onNavigateBack: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(start = 16.dp, top = 32.dp, end = 16.dp, bottom = 16.dp)
    ) {
        Row(
            modifier = Modifier.align(Alignment.TopStart),
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
            modifier = Modifier.fillMaxSize(),
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
            InfoCard("Author", "Deimos Hall")
            InfoCard("License", "GPLv3")
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