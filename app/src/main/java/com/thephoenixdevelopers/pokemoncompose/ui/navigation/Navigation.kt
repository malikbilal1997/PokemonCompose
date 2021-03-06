package com.thephoenixdevelopers.pokemoncompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.thephoenixdevelopers.pokemoncompose.ui.screens.detail.DetailScreen
import com.thephoenixdevelopers.pokemoncompose.ui.screens.home.HomeScreen
import com.thephoenixdevelopers.pokemoncompose.ui.screens.splash.SplashScreen

@Composable
fun Navigation(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {

        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = "${Screen.Detail.route}/{pokemonUrl}/{pokemonName}",
            arguments = listOf(
                navArgument("pokemonUrl") {
                    type = NavType.StringType
                },
                navArgument("pokemonName") {
                    type = NavType.StringType
                },
            )

        ) {

            val pokemonUrl = rememberSaveable {
                it.arguments?.getString("pokemonUrl") ?: String()
            }

            val pokemonName = rememberSaveable {
                it.arguments?.getString("pokemonName") ?: String()
            }

            DetailScreen(
                pokemonUrl = pokemonUrl,
                pokemonName = pokemonName,
                navController = navController
            )
        }

        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

    }

}