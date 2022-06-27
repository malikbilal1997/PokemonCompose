package com.thephoenixdevelopers.pokemoncompose.repos

import com.thephoenixdevelopers.pokemoncompose.network.ApiInterface
import com.thephoenixdevelopers.pokemoncompose.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PokemonRepoImpl(

    private val apiInterface: ApiInterface

) : PokemonRepo {

    override fun getPokemonList(

        limit: Int, offset: Int

    ) = flow {

        if (offset == 0) {

            emit(Response.LoadFirst)

        } else {

            emit(Response.LoadMore)
        }

        runCatching {

            apiInterface.getPokemonList(limit, offset)

        }.onSuccess {

            emit(Response.Success(it.results))

        }.onFailure {

            emit(Response.Error(it.message))
        }

    }.flowOn(Dispatchers.IO)


}