package uk.adbsalam.portfolio.theming.appbackground


import android.graphics.RuntimeShader
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.ShaderBrush
import uk.adbsalam.portfolio.theming.DeepDarkColorScheme.darkGradientColor
import uk.adbsalam.portfolio.theming.appbackground.snow.snowfall
import uk.adbsalam.portfolio.theming.christmas_gradient_color
import uk.adbsalam.portfolio.theming.dark_gradient_color_one
import uk.adbsalam.portfolio.theming.dark_gradient_color_two
import uk.adbsalam.portfolio.theming.light_gradient_color_one
import uk.adbsalam.portfolio.theming.light_gradient_color_two
import uk.adbsalam.portfolio.utils.Theme

/**
 * @param theme current theme to be implemented
 * @param content content to show on gradient column
 *
 * This will be base background for app alongside snow animations
 */
@Composable
fun GradientColumn(
    theme: Theme,
    content: @Composable () -> Unit
) {
    val gradientColorOne = when {
        theme == Theme.SYSTEM && isSystemInDarkTheme() -> dark_gradient_color_one
        theme == Theme.DARK -> dark_gradient_color_one
        theme == Theme.CHRISTMAS -> christmas_gradient_color
        theme == Theme.DEEP_DARK -> darkGradientColor
        else -> light_gradient_color_one
    }

    val gradientColorTwo = when {
        theme == Theme.SYSTEM && isSystemInDarkTheme() -> dark_gradient_color_two
        theme == Theme.DARK -> dark_gradient_color_two
        theme == Theme.CHRISTMAS -> christmas_gradient_color
        theme == Theme.DEEP_DARK -> darkGradientColor
        else -> light_gradient_color_two
    }
    
    val modifier = if (theme == Theme.CHRISTMAS) Modifier.snowfall() else Modifier
    val gradientModifier = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        Modifier.drawWithCache {
            val shader = RuntimeShader(CUSTOM_SHADER)
            val shaderBrush = ShaderBrush(shader)
            shader.setFloatUniform("resolution", size.width, size.height)
            onDrawBehind {
                shader.setColorUniform(
                    "color",
                    android.graphics.Color.valueOf(
                        gradientColorTwo.red,
                        gradientColorTwo.green,
                        gradientColorTwo.blue,
                        gradientColorTwo.alpha
                    )
                )
                shader.setColorUniform(
                    "color2",
                    android.graphics.Color.valueOf(
                        gradientColorOne.red,
                        gradientColorOne.green,
                        gradientColorOne.blue,
                        gradientColorOne.alpha
                    )
                )
                drawRect(shaderBrush)
            }
        }
    } else Modifier

    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(gradientModifier)
            .then(modifier)
    ) {
        content()
    }
}