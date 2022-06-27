package com.thephoenixdevelopers.pokemoncompose.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.thephoenixdevelopers.pokemoncompose.ui.navigation.Navigation
import com.thephoenixdevelopers.pokemoncompose.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            PokedexTheme {

                // Setting up the Jetpack Compose Navigation.
                val navController = rememberNavController()

                Navigation(navController)
            }
        }
    }
}