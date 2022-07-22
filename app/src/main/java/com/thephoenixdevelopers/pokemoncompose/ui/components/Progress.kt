package com.thephoenixdevelopers.pokemoncompose.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ProgressCircle(
    modifier: Modifier = Modifier,
    progressBarSize: Dp = 48.dp,
    progressBarStroke: Dp = 4.dp,
    progressBarColor: Color = MaterialTheme.colors.primary,
) {
    CircularProgressBar(
        modifier = modifier,
        color = progressBarColor,
        progressSize = progressBarSize,
        strokeSize = progressBarStroke,
    )
}

@Composable
fun ProgressRow(
    modifier: Modifier = Modifier,
    progressRowHeight: Dp = 56.dp,
    progressBarSize: Dp = 48.dp,
    progressBarStroke: Dp = 4.dp,
    progressBarColor: Color = MaterialTheme.colors.primary,
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(progressRowHeight),
    ) {

        CircularProgressBar(
            color = progressBarColor,
            progressSize = progressBarSize,
            strokeSize = progressBarStroke,
            modifier = modifier
                .align(Alignment.Center),
        )
    }

}

@Composable
fun ImageProgress(
    modifier: Modifier = Modifier,
    progressBarSize: Dp = 48.dp,
    progressBarStroke: Dp = 4.dp,
    progressBarColor: Color = MaterialTheme.colors.primary,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        CircularProgressBar(
            color = progressBarColor,
            progressSize = progressBarSize,
            strokeSize = progressBarStroke,
            modifier = modifier
                .align(Alignment.Center),
        )
    }

}

@Composable
fun CircularProgressBar(
    modifier: Modifier = Modifier,
    strokeSize: Dp = 4.dp,
    progressSize: Dp = 48.dp,
    animationDuration: Int = 800,
    rightRotation: Boolean = true,
    strokeCap: StrokeCap = StrokeCap.Round,
    color: Color = MaterialTheme.colors.primary,
) {

    val transition = rememberInfiniteTransition()

    val angle by transition.animateFloat(
        initialValue = 0f,
        targetValue = when {
            rightRotation -> 360f
            else -> -360f
        },
        animationSpec = infiniteRepeatable(
            tween(
                easing = LinearEasing,
                durationMillis = animationDuration,
            )
        )
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Canvas(modifier = modifier.size(progressSize)) {
            drawArc(
                color = color,
                startAngle = angle,
                sweepAngle = 270f,
                useCenter = false,
                style = Stroke(
                    strokeSize.toPx(),
                    cap = strokeCap,
                ),
            )
        }
    }
}