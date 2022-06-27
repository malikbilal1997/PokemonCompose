package com.thephoenixdevelopers.pokemoncompose.utils

object PokemonImageUtil {

    fun getImageUrl(url: String): String {
        return IMAGE_URL + getLastBitFromUrl(url) + ".png"
    }

    private fun getLastBitFromUrl(url: String): String {
        return url.replaceFirst(".*/([^/?]+).*".toRegex(), "$1")
    }
}