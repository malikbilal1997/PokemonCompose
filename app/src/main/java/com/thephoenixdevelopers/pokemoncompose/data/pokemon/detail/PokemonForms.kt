package com.thephoenixdevelopers.pokemoncompose.data.pokemon.detail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonForms(

    @SerializedName("name")
    var name: String = String(),

    @SerializedName("url")
    var url: String = String(),

) : Parcelable
