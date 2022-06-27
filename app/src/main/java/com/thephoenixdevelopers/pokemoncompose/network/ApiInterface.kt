package com.thephoenixdevelopers.pokemoncompose.network

import com.thephoenixdevelopers.pokemoncompose.data.PokemonList
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {

    @GET("pokemon")
    suspend fun getPokemonList(

        @Query("limit") limit: Int,
        @Query("offset") offset: Int

    ): PokemonList


}