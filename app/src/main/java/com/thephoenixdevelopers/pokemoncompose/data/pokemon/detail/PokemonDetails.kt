package com.thephoenixdevelopers.pokemoncompose.data.pokemon.detail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonDetails(

    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("order")
    var order: Int = 0,

    @SerializedName("height")
    var height: Int = 0,

    @SerializedName("weight")
    var weight: Int = 0,

    @SerializedName("name")
    var name: String = String(),

    @SerializedName("forms")
    var forms: List<PokemonForms> = emptyList(),

    @SerializedName("sprites")
    var sprites: PokemonSprites = PokemonSprites(),

) : Parcelable
