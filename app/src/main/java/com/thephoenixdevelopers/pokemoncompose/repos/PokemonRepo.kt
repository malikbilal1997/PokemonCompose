package com.thephoenixdevelopers.pokemoncompose.repos

import com.thephoenixdevelopers.pokemoncompose.utils.Response
import com.thephoenixdevelopers.pokemoncompose.data.Pokemon
import kotlinx.coroutines.flow.Flow


interface PokemonRepo {

    fun getPokemonList(limit: Int, offset: Int): Flow<Response<List<Pokemon>>>

}