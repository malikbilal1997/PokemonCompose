package com.thephoenixdevelopers.pokemoncompose.utils

object PokemonImageUtil {

    fun getDefaultImageUrl(url: String): String {
        return DEFAULT_IMAGE_URL + getLastBitFromUrl(url) + ".png"
    }

    fun getHighResImageUrl(url: String): String {
        return HIGH_RES_IMAGE_URL + getLastBitFromUrl(url) + ".png"
    }

    private fun getLastBitFromUrl(url: String): String {
        return url.replaceFirst(".*/([^/?]+).*".toRegex(), "$1")
    }
}