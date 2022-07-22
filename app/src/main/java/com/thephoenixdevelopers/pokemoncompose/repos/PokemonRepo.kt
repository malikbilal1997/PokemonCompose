package com.thephoenixdevelopers.pokemoncompose.repos

import com.thephoenixdevelopers.pokemoncompose.data.pokemon.detail.PokemonDetails
import com.thephoenixdevelopers.pokemoncompose.utils.PageResponse
import com.thephoenixdevelopers.pokemoncompose.data.pokemon.list.Pokemon
import com.thephoenixdevelopers.pokemoncompose.utils.Response
import kotlinx.coroutines.flow.Flow


interface PokemonRepo {

    /**
     * @param name The name of the pokemon.
     * */
    fun getPokemonDetails(name: String): Flow<Response<PokemonDetails>>

    /**
     * @param limit How many items to fetch.
     * @param offset How many items to skip.
     * */
    fun getPokemonList(limit: Int, offset: Int): Flow<PageResponse<List<Pokemon>>>

}