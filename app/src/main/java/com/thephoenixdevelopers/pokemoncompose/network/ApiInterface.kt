package com.thephoenixdevelopers.pokemoncompose.network

import com.thephoenixdevelopers.pokemoncompose.data.pokemon.detail.PokemonDetails
import com.thephoenixdevelopers.pokemoncompose.data.pokemon.list.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiInterface {

    @GET("pokemon")
    suspend fun getPokemonList(

        @Query("limit") limit: Int,
        @Query("offset") offset: Int

    ): PokemonList


    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(

        @Path("name") name: String

    ): PokemonDetails


}