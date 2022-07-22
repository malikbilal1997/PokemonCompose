package com.thephoenixdevelopers.pokemoncompose.repos

import com.thephoenixdevelopers.pokemoncompose.network.ApiInterface
import com.thephoenixdevelopers.pokemoncompose.utils.PageResponse
import com.thephoenixdevelopers.pokemoncompose.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PokemonRepoImpl(

    private val apiInterface: ApiInterface,

    ) : PokemonRepo {

    override fun getPokemonList(

        limit: Int, offset: Int,

        ) = flow {

        if (offset == 0) {

            emit(PageResponse.LoadFirst)

        } else {

            emit(PageResponse.LoadMore)
        }

        runCatching {
            apiInterface.getPokemonList(limit, offset)
        }.onSuccess {
            emit(PageResponse.Success(it.results))
        }.onFailure {
            emit(PageResponse.Error(it.message))
        }

    }.flowOn(Dispatchers.IO)

    override fun getPokemonDetails(
        name: String,
    ) = flow {

        emit(Response.Loading)

        runCatching {
            apiInterface.getPokemonDetails(name)
        }.onSuccess {
            emit(Response.Success(it))
        }.onFailure {
            emit(Response.Error(it.message))
        }

    }.flowOn(Dispatchers.IO)

}