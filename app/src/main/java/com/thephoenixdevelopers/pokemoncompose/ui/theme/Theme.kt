package com.thephoenixdevelopers.pokemoncompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    surface = Black,
    onSurface = White,
    primary = Grey400,
    onPrimary = Black,
    background = Black,
    onBackground = White,
    primaryVariant = Grey500,
)

private val LightColorPalette = lightColors(
    surface = White,
    onSurface = Black,
    onPrimary = White,
    primary = Grey800,
    background = White,
    onBackground = Black,
    primaryVariant = Grey900
)

@Composable
fun PokedexTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        shapes = Shapes,
        content = content,
        typography = Typography,
    )
}