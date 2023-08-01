package uk.adbsalam.portfolio.info.feature.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CircularChart(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    percent: Float
) {

    var percentFloat by remember { mutableStateOf(0f) }

    LaunchedEffect(key1 = null) {
        percentFloat = percent
    }

    val progressAnimation by animateFloatAsState(
        targetValue = percentFloat,
        animationSpec = tween(durationMillis = 1000, easing = LinearEasing)
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(100.dp),
            strokeWidth = 20.dp,
            progress = progressAnimation,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )

        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = subTitle,
            fontSize = 16.sp,
        )
    }
}

@Composable
@Preview
internal fun CircularChartPreview() {
    CircularChart(
        title = "Android",
        subTitle = "kotlin",
        percent = 0.5f
    )
}