package com.thephoenixdevelopers.pokemoncompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
            route = "${Screen.Detail.route}/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                }
            )

        ) {

            val name = remember {
                it.arguments?.getString("name")
            }

            DetailScreen(navController = navController)
        }

        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

    }

}