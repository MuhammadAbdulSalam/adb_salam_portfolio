package uk.adbsalam.portfolio.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Preview
@Composable
fun LoadingLotti(
    modifier: Modifier = Modifier,
    msg: String = ""
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.ic_loading))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = Integer.MAX_VALUE,
        isPlaying = true
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
        )
        Text(
            text = msg,
            color = Color.Gray,
            fontWeight = FontWeight.Bold
        )
    }
}