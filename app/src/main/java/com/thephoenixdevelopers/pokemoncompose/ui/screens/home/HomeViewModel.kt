package com.thephoenixdevelopers.pokemoncompose.ui.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thephoenixdevelopers.pokemoncompose.data.pokemon.list.Pokemon
import com.thephoenixdevelopers.pokemoncompose.repos.PokemonRepo
import com.thephoenixdevelopers.pokemoncompose.utils.PageResponse
import dagger.hilt.android.lifecycle.HiltViewModel


import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

    private val pokemonRepo: PokemonRepo

) : ViewModel() {

    private var limit = 20

    private var offset = 0

    var lastLoading = mutableStateOf(false)

    var errorLoading = mutableStateOf(false)

    var firstLoading = mutableStateOf(false)

    var moreLoading = mutableStateOf(false)

    var pokemonList = mutableStateOf(listOf<Pokemon>())

    init {

        fetchPokemonList()
    }

    fun fetchPokemonList() {

        viewModelScope.launch {

            pokemonRepo.getPokemonList(

                limit, offset

            ).collect { response ->

                when (response) {

                    is PageResponse.Idle -> {
                        moreLoading.value = false
                        firstLoading.value = false
                    }

                    is PageResponse.Error -> {

                        Timber.d("Error -> %s", response.error)

                        moreLoading.value = false

                        firstLoading.value = false

                        errorLoading.value = pokemonList.value.isEmpty()

                    }

                    is PageResponse.Success -> {

                        val combineList = mutableListOf<Pokemon>()

                        combineList.addAll(pokemonList.value)

                        combineList.addAll(response.success)

                        lastLoading.value = response.success.size < limit

                        // Assigning the Combine Pokemon List to Mutable State.
                        pokemonList.value = combineList

                        offset += limit

                        moreLoading.value = false

                        firstLoading.value = false

                        errorLoading.value = pokemonList.value.isEmpty()
                    }

                    is PageResponse.LoadMore -> {

                        moreLoading.value = true
                        firstLoading.value = false
                        errorLoading.value = false

                    }

                    is PageResponse.LoadFirst -> {

                        moreLoading.value = false
                        firstLoading.value = true
                        errorLoading.value = false
                    }
                }
            }
        }

    }

}