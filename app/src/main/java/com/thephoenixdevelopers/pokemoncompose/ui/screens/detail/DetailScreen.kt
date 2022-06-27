package com.thephoenixdevelopers.pokemoncompose.ui.screens.detail

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thephoenixdevelopers.pokemoncompose.ui.theme.PokedexTheme

@Composable
fun DetailScreen(
    navController: NavController
) {

}

@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DetailScreenPreview() {

    PokedexTheme {
        DetailScreen(navController = rememberNavController())
    }

}