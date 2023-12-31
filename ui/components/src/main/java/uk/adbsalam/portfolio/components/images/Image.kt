package uk.adbsalam.portfolio.components.images

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uk.adbsalam.portfolio.components.R
import uk.adbsalam.portfolio.theming.PreviewLight
import uk.adbsalam.snapit.annotations.SnapIt

@Composable
fun AdbImage(
    modifier: Modifier = Modifier,
    @DrawableRes
    resourceId: Int,
    tag: String = "",
    contentScale: ContentScale = ContentScale.FillBounds
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = resourceId),
        contentDescription = tag,
        contentScale = contentScale,
    )
}

@PreviewLight
@Composable
@SnapIt
internal fun AdbImagePreview() {
    AdbImage(
        modifier = Modifier.size(200.dp),
        resourceId = R.drawable.preview,
    )
}

@Composable
fun AdbMainLogo(
    modifier: Modifier = Modifier
) {
    AdbImage(
        modifier = modifier,
        resourceId = R.drawable.ic_logo_main,
    )
}

@PreviewLight
@Composable
@SnapIt
internal fun AdbMainLogoPreview() {
    AdbMainLogo(
        modifier = Modifier.size(150.dp)
    )
}