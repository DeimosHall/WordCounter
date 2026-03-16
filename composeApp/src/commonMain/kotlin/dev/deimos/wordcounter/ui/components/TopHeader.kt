package dev.deimos.wordcounter.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import wordcounter.composeapp.generated.resources.Res
import wordcounter.composeapp.generated.resources.app_name
import wordcounter.composeapp.generated.resources.info_circle

@Composable
fun TopHeader(renderTitle: Boolean, onInfoClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        if (renderTitle) {
            Text(
                text = stringResource(Res.string.app_name),
                fontSize = 25.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        IconButton(onClick = onInfoClick, modifier = Modifier.align(Alignment.CenterEnd)) {
            Icon(
                painter = painterResource(Res.drawable.info_circle),
                contentDescription = "Navigate to about screen",
                tint = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}