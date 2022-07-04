package com.thephoenixdevelopers.pokemoncompose.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.thephoenixdevelopers.pokemoncompose.ui.theme.PokedexTheme

@Composable
fun ProgressCircle(
    modifier: Modifier = Modifier,
    progressBarSize: Dp = 48.dp,
    progressBarStroke: Dp = 4.dp,
    progressBarColor: Color = MaterialTheme.colors.primary
) {

    CircularProgressIndicator(
        color = progressBarColor,
        strokeWidth = progressBarStroke,
        modifier = modifier
            .size(progressBarSize)
    )
}

@Composable
fun ProgressRow(
    modifier: Modifier = Modifier,
    progressRowHeight: Dp = 56.dp,
    progressBarSize: Dp = 48.dp,
    progressBarStroke: Dp = 4.dp,
    progressBarColor: Color = MaterialTheme.colors.primary
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(progressRowHeight)
    ) {

        CircularProgressIndicator(
            color = progressBarColor,
            strokeWidth = progressBarStroke,
            modifier = Modifier
                .align(Alignment.Center)
                .size(progressBarSize)
        )
    }

}


@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun ProgressCirclePreview() {

    PokedexTheme {
        ProgressCircle()
    }
}

@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun ProgressRowPreview() {

    PokedexTheme {
        ProgressRow()
    }
}