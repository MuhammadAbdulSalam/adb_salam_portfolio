package uk.adbsalam.portfolio.reviews.feature.components.reviewcard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.adbsalam.portfolio.components.R
import uk.adbsalam.portfolio.reviews.data.objects.ReviewItems
import uk.adbsalam.portfolio.theming.Adb_Theme

/**
 * @param review reviews data to be populated on title
 * This includes name, designation and LinkedIn icon
 */
@Composable
internal fun ReviewTitle(
    review: ReviewItems.Review
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_linked_in),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(
                text = review.name,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = review.designation,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
internal fun ReviewTitlePreview() {
    Adb_Theme {
        ReviewTitle(review = ReviewItems.createMock().reviews.first())
    }
}