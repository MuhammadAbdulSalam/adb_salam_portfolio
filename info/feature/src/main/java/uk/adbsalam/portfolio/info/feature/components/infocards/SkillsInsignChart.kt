package uk.adbsalam.portfolio.info.feature.components.infocards

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.adbsalam.portfolio.components.R
import uk.adbsalam.portfolio.info.feature.components.InfoTitle
import uk.adbsalam.portfolio.info.feature.components.charts.HorizontalChart
import uk.adbsalam.portfolio.info.feature.infoList
import uk.adbsalam.portfolio.theming.Adb_Theme
import uk.adbsalam.portfolio.theming.adbRoundedBackground

@Composable
internal fun SkillsInsightCard() {

    var expandInfoBars by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .adbRoundedBackground()
            .padding(14.dp)
    ) {

        InfoTitle(
            title = "Orders Insight"
        )

        Row(
            Modifier.align(Alignment.Start),
            verticalAlignment = Alignment.Bottom
        ) {

            Text(
                text = "Total Promo Code Savings:",
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "£237.83",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.width(8.dp))
            
            Icon(
                painter = painterResource(id = R.drawable.ic_discount),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(20.dp)
            )

        }

        Spacer(modifier = Modifier.height(10.dp))

        infoList.subList(0, 5).forEach {
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalChart(
                subTitle = it.name,
                percent = it.value
            )
        }

        AnimatedVisibility(
            visible = expandInfoBars,
        ) {
            Column(Modifier.fillMaxWidth()) {
                infoList.subList(5, infoList.size).forEach {
                    Spacer(modifier = Modifier.height(16.dp))
                    HorizontalChart(
                        subTitle = it.name,
                        percent = it.value
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        TextButton(
            modifier = Modifier.align(Alignment.End),
            onClick = { expandInfoBars = !expandInfoBars }
        ) {
            Text(text = if (expandInfoBars) "see less" else "see more")
        }
    }
}

@Preview
@Composable
internal fun SkillsInsightCardLightPreview(){
    Adb_Theme {
        SkillsInsightCard()
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
internal fun SkillsInsightCardDarkPreview(){
    Adb_Theme(true) {
        SkillsInsightCard()
    }
}