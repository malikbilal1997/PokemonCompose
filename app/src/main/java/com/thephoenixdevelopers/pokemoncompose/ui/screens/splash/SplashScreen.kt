package com.thephoenixdevelopers.pokemoncompose.ui.screens.splash

import android.content.res.Configuration
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CatchingPokemon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thephoenixdevelopers.pokemoncompose.ui.navigation.Screen
import com.thephoenixdevelopers.pokemoncompose.ui.theme.PokedexTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {

    var startAnimation by remember {
        mutableStateOf(false)
    }

    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )

    LaunchedEffect(key1 = true) {

        startAnimation = true

        delay(3000)

        navController.popBackStack()

        navController.navigate(
            Screen.Home.route
        )
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colors.surface
            )
    ) {
        Image(
            alpha = alphaAnimation.value,
            contentDescription = null,
            colorFilter = ColorFilter.tint(
                MaterialTheme.colors.onSurface
            ),
            modifier = Modifier.size(120.dp),
            imageVector = Icons.Rounded.CatchingPokemon
        )
    }


}

@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SplashScreenPreview() {

    PokedexTheme {
        SplashScreen(navController = rememberNavController())
    }

}