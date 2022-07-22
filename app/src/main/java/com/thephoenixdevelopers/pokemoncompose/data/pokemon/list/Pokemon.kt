package com.thephoenixdevelopers.pokemoncompose.data.pokemon.list

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(

    @SerializedName("name")
    var name: String = String(),

    @SerializedName("url")
    var url: String = String(),

) :Parcelable
