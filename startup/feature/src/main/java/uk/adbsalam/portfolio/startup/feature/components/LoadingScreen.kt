package uk.adbsalam.portfolio.startup.feature.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.adbsalam.portfolio.components.images.AdbMainLogo
import uk.adbsalam.portfolio.theming.Adb_Theme
import uk.adbsalam.portfolio.theming.PreviewDark
import uk.adbsalam.portfolio.theming.PreviewLight
import uk.adbsalam.snapit.annotations.SnapIt

@Composable
internal fun LoadingScreen() {

    val animate = remember { mutableStateOf(false) }

    LaunchedEffect(key1 = null) {
        animate.value = true
    }

    AnimatedVisibility(
        modifier = Modifier.fillMaxSize(),
        visible = animate.value,
        enter = fadeIn(tween(500)),
        exit = fadeOut(tween(500))
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AdbMainLogo(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(150.dp)
            )

            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 100.dp)
                    .size(50.dp),
                strokeWidth = 4.dp
            )
        }
    }
}

@PreviewLight
@Composable
internal fun LoadingScreenLightPreview() {
    Adb_Theme {
        LoadingScreen()
    }
}

@PreviewDark
@Composable
internal fun LoadingScreenDarkPreview() {
    Adb_Theme(isSystemDark = true) {
        LoadingScreen()
    }
}