package com.thephoenixdevelopers.pokemoncompose.ui.navigation

sealed class Screen(val route: String) {

    object Home : Screen(route = "home_screen")
    object Detail : Screen(route = "detail_screen")
    object Splash : Screen(route = "splash_screen")

}
