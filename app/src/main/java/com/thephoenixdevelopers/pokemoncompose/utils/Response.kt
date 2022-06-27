package com.thephoenixdevelopers.pokemoncompose.utils

sealed class Response<out T> {

    object Idle : Response<Nothing>()

    object LoadMore : Response<Nothing>()

    object LoadFirst : Response<Nothing>()

    data class Success<T>(val success: T) : Response<T>()

    data class Error(val error: String?) : Response<Nothing>()

}
