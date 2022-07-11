package com.thephoenixdevelopers.pokemoncompose.ui.screens.detail

import androidx.lifecycle.ViewModel
import com.thephoenixdevelopers.pokemoncompose.repos.PokemonRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(

    private val pokemonRepo: PokemonRepo

) : ViewModel() {


}