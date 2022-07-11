package com.thephoenixdevelopers.pokemoncompose.ui.screens.detail

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thephoenixdevelopers.pokemoncompose.ui.components.Toolbar
import com.thephoenixdevelopers.pokemoncompose.ui.theme.PokedexTheme

@Composable
fun DetailScreen(
    pokemonName: String = String(),
    navController: NavController,
    viewModel: DetailViewModel = hiltViewModel()
) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
    ) {

        Box(modifier = Modifier.fillMaxSize()) {

            Column(modifier = Modifier.fillMaxSize()) {

                Toolbar(
                    backBtn = true,
                    titleCenter = true,
                    navController = navController,
                    title = pokemonName.capitalize(
                        Locale.current
                    ),
                    bgColor = MaterialTheme.colors.surface,
                    txtColor = MaterialTheme.colors.onSurface,
                    btnColor = MaterialTheme.colors.onSurface
                )
            }
        }
    }

}

@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DetailScreenPreview() {

    PokedexTheme {
        DetailScreen(navController = rememberNavController())
    }

}