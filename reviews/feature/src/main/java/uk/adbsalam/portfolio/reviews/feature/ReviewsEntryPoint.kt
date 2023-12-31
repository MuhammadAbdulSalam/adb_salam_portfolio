package uk.adbsalam.portfolio.reviews.feature

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import uk.adbsalam.portfolio.components.ErrorPage
import uk.adbsalam.portfolio.components.LoadingLotti
import uk.adbsalam.portfolio.reviews.data.objects.ReviewItems
import uk.adbsalam.portfolio.theming.PreviewDark
import uk.adbsalam.portfolio.theming.PreviewLight
import uk.adbsalam.portfolio.theming.appbackground.Adb_Screen_Theme
import uk.adbsalam.snapit.annotations.SnapIt

/**
 * @param viewModel view model to be used for this screen
 *
 * This is entry point to Reviews screen
 * Perform all functionality that might block Previews
 */
@Composable
fun Reviews(
    viewModel: ReviewsViewModel = hiltViewModel()
) {
    val uiState by viewModel.viewState.collectAsState()

    Reviews(
        uiState = uiState,
        retry = viewModel::fetchReviews
    )
}

/**
 * @param uiState Current UI State to show on screen
 * Changes state based on uiState such as loading or show reviews
 */
@Composable
private fun Reviews(
    uiState: ReviewsState,
    retry: () -> Unit
) {
    when (uiState) {
        ReviewsState.OnLoading ->
            LoadingLotti(
                modifier = Modifier.fillMaxSize(),
                msg = "Loading"
            )

        is ReviewsState.OnError -> {
            ErrorPage(
                msg = uiState.msg,
                retry = retry
            )
        }

        is ReviewsState.OnReviews -> {
            ReviewsScreen(reviews = uiState.reviews)
        }
    }
}

@PreviewLight
@Composable
@SnapIt(gif = true, end = 1000L)
internal fun ReviewsPreviewLight() {
    Adb_Screen_Theme {
        Reviews(
            uiState = ReviewsState.OnReviews(ReviewItems.createMock()),
            retry = { /*unused*/ }
        )
    }
}

@PreviewDark
@Composable
@SnapIt(gif = true, end = 1000L, isDark = true)
internal fun ReviewsPreviewDark() {
    Adb_Screen_Theme(isDark = true) {
        Reviews(
            uiState = ReviewsState.OnReviews(ReviewItems.createMock()),
            retry = { /*unused*/ }
        )
    }
}