package com.thephoenixdevelopers.pokemoncompose.data.pokemon.detail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonSprites(

    @SerializedName("back_shiny")
    var backShiny: String? = String(),

    @SerializedName("back_default")
    var backDefault: String? = String(),

    @SerializedName("back_female")
    var backFemale: String? = String(),

    @SerializedName("front_shiny")
    var frontShiny: String? = String(),

    @SerializedName("front_female")
    var frontFemale: String? = String(),

    @SerializedName("front_default")
    var frontDefault: String? = String(),

    @SerializedName("back_shiny_female")
    var backShinyFemale: String? = String(),

    @SerializedName("front_shiny_female")
    var frontShinyFemale: String? = String(),

) : Parcelable {

    fun getSpriteList(): List<String> {

        val sprites = mutableListOf<String>()

        frontDefault?.let { it ->
            sprites.add(it)
        }
        backDefault?.let { it ->
            sprites.add(it)
        }

        frontShiny?.let { it ->
            sprites.add(it)
        }
        backShiny?.let { it ->
            sprites.add(it)
        }

        frontFemale?.let { it ->
            sprites.add(it)
        }
        backFemale?.let { it ->
            sprites.add(it)
        }

        frontShinyFemale?.let { it ->
            sprites.add(it)
        }
        backShinyFemale?.let { it ->
            sprites.add(it)
        }

        return sprites
    }

}
