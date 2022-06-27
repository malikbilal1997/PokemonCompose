package com.thephoenixdevelopers.pokemoncompose.ui.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thephoenixdevelopers.pokemoncompose.data.Pokemon
import com.thephoenixdevelopers.pokemoncompose.repos.PokemonRepo
import com.thephoenixdevelopers.pokemoncompose.utils.Response
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

    // For Checking if the Network Call Running Already.
    private var callRunning = false

    // For Checking if More Records Available on Server.
    private var canFetchMore = false

    var nothingFound = mutableStateOf(false)

    var firstLoading = mutableStateOf(false)

    var moreLoading = mutableStateOf(false)

    var pokemonList = mutableStateOf(listOf<Pokemon>())

    init {

        fetchPokemonList()
    }

    fun fetchPokemonList() {

        if (!callRunning && !canFetchMore) {

            // Setting Network Call Flag to True When Request Start.
            callRunning = true

            viewModelScope.launch {

                pokemonRepo.getPokemonList(

                    limit, offset

                ).collect { response ->

                    when (response) {

                        is Response.Idle -> {
                            moreLoading.value = false
                            firstLoading.value = false
                        }

                        is Response.Error -> {

                            Timber.d("Error -> %s", response.error)

                            callRunning = false

                            moreLoading.value = false

                            firstLoading.value = false

                            nothingFound.value = pokemonList.value.isEmpty()

                        }

                        is Response.Success -> {

                            Timber.d("Success -> Get Pokemon List Completed")

                            Timber.d("Pokemon List Size -> %s", response.success.size)

                            val combineList = mutableListOf<Pokemon>()

                            combineList.addAll(pokemonList.value)

                            combineList.addAll(response.success)

                            canFetchMore = response.success.size < limit

                            // Assigning the Combine Pokemon List to Mutable State.
                            pokemonList.value = combineList

                            offset += limit

                            callRunning = false

                            moreLoading.value = false

                            firstLoading.value = false

                            nothingFound.value = pokemonList.value.isEmpty()
                        }

                        is Response.LoadMore -> {

                            moreLoading.value = true
                            firstLoading.value = false
                            nothingFound.value = false

                        }

                        is Response.LoadFirst -> {

                            moreLoading.value = false
                            firstLoading.value = true
                            nothingFound.value = false
                        }
                    }
                }
            }

        }

    }

}