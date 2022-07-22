package com.thephoenixdevelopers.pokemoncompose.data.pokemon.list

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonList(

    @SerializedName("count")
    var count: Int = 0,

    @SerializedName("next")
    var next: String? = String(),

    @SerializedName("previous")
    var previous: String? = String(),

    @SerializedName("results")
    var results: List<Pokemon> = emptyList()

) : Parcelable
