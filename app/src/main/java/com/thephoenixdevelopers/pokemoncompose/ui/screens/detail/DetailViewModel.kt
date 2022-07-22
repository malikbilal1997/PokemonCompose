package com.thephoenixdevelopers.pokemoncompose.ui.screens.detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thephoenixdevelopers.pokemoncompose.data.pokemon.detail.PokemonDetails
import com.thephoenixdevelopers.pokemoncompose.repos.PokemonRepo
import com.thephoenixdevelopers.pokemoncompose.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(

    private val pokemonRepo: PokemonRepo,

) : ViewModel() {

    var loadingError = mutableStateOf(false)

    var loadingDetails = mutableStateOf(false)

    var pokemonDetails = mutableStateOf(PokemonDetails())

    fun getPokemonDetails(name: String) {

        viewModelScope.launch {

            pokemonRepo.getPokemonDetails(name).collect { response ->

                when (response) {

                    is Response.Idle -> {
                        loadingDetails.value = false
                    }

                    is Response.Error -> {

                        Timber.d("Error -> %s", response.error)

                        loadingError.value = true
                        loadingDetails.value = false
                    }

                    is Response.Loading -> {
                        loadingError.value = false
                        loadingDetails.value = true
                    }

                    is Response.Success -> {
                        loadingError.value = false
                        loadingDetails.value = false
                        pokemonDetails.value = response.success
                    }
                }

            }
        }
    }

}