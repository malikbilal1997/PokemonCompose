package com.thephoenixdevelopers.pokemoncompose.utils

sealed class PageResponse<out T> {

    object Idle : PageResponse<Nothing>()

    object LoadMore : PageResponse<Nothing>()

    object LoadFirst : PageResponse<Nothing>()

    data class Success<T>(val success: T) : PageResponse<T>()

    data class Error(val error: String?) : PageResponse<Nothing>()

}
