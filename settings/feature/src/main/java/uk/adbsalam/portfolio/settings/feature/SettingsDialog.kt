package uk.adbsalam.portfolio.settings.feature

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties
import uk.adbsalam.portfolio.utils.Theme

/**
 * @param onDynamicColor action on new dynamic color value is set
 * @param onTheme action on new theme value is selected
 * @param onDismiss action on Dialog Dismiss
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsDialog(
    onDynamicColor: (Boolean) -> Unit,
    onTheme: (Theme) -> Unit,
    onDismiss: () -> Unit
) {

    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            properties = DialogProperties(
                usePlatformDefaultWidth = false,
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {

            if (!LocalInspectionMode.current) {
                SettingsScreen(
                    onDynamicColor = onDynamicColor,
                    onTheme = onTheme,
                    onDismiss = {
                        openDialog.value = false
                        onDismiss()
                    }
                )
            } else { // to preview settings dialog
                SettingsScreen(
                    theme = Theme.DARK,
                    isDynamic = false,
                    onDynamicColor = {},
                    onTheme = {},
                    onDismiss = {
                        openDialog.value = false
                        onDismiss()
                    }
                )
            }
        }
    }
}

@Composable
@Preview
fun SettingsDialogPreview() {
    SettingsDialog(
        onDynamicColor = { /** unused **/ },
        onTheme = { /** unused **/ },
        onDismiss = { /** unused **/ }
    )
}