package uk.adbsalam.portfolio.info.feature

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import uk.adbsalam.portfolio.info.data.objects.Infographics
import uk.adbsalam.portfolio.info.data.objects.WorkHistory
import uk.adbsalam.portfolio.info.feature.components.WorkInfo
import uk.adbsalam.portfolio.info.feature.components.infocards.AndroidMainCard
import uk.adbsalam.portfolio.info.feature.components.infocards.SkillsInsightCard
import uk.adbsalam.portfolio.theming.PreviewDark
import uk.adbsalam.portfolio.theming.PreviewLight
import uk.adbsalam.portfolio.theming.adbRoundedBackground
import uk.adbsalam.portfolio.theming.appbackground.Adb_Screen_Theme
import uk.adbsalam.snapit.annotations.SnapIt

/**
 * Main Info screen upon successfully loading data
 * This is the main Info Screen to show
 */
@Composable
internal fun InfoScreen(
    infographics: Infographics,
    workHistory: WorkHistory
) {
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(scrollState),
    ) {

        Text(
            modifier = Modifier.statusBarsPadding(),
            text = "Primary Android Skills",
            style = MaterialTheme.typography.titleMedium
        )

        AndroidMainCard()

        Text(
            text = "Have a look at my skill set",
            style = MaterialTheme.typography.titleMedium
        )

        SkillsInsightCard(infographics = infographics)

        Text(
            text = "My Work History",
            style = MaterialTheme.typography.titleMedium
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .adbRoundedBackground()
                .padding(vertical = 20.dp),
        ) {

            workHistory.workHistory.forEachIndexed { index, item ->
                WorkInfo(
                    showDivider = index != workHistory.workHistory.lastIndex,
                    workHistory = item,
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
    }

    if (scrollState.value > 0) {
        BackHandler {
            scope.launch {
                scrollState.animateScrollTo(0)
            }
        }
    }
}

@PreviewLight
@Composable
@SnapIt
internal fun InfoScreenLight() {
    Adb_Screen_Theme {
        InfoScreen(
            infographics = Infographics.createMock(),
            workHistory = WorkHistory.createMock()
        )
    }
}

@PreviewDark
@Composable
@SnapIt(isDark = true)
internal fun InfoScreenDark() {
    Adb_Screen_Theme(isDark = true) {
        InfoScreen(
            infographics = Infographics.createMock(),
            workHistory = WorkHistory.createMock()
        )
    }
}