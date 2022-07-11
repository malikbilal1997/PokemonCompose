package com.thephoenixdevelopers.pokemoncompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.thephoenixdevelopers.pokemoncompose.data.Pokemon
import com.thephoenixdevelopers.pokemoncompose.ui.navigation.Screen
import com.thephoenixdevelopers.pokemoncompose.ui.theme.Grey100
import com.thephoenixdevelopers.pokemoncompose.ui.theme.Grey900
import com.thephoenixdevelopers.pokemoncompose.utils.PokemonImageUtil.getImageUrl


@Composable
fun PokemonGridItem(
    pokemon: Pokemon = Pokemon(),
    navController: NavController
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(
                when {
                    isSystemInDarkTheme() -> {
                        Grey900
                    }
                    else -> {
                        Grey100
                    }
                }
            )
            .clickable {
                navController.navigate(
                    "${Screen.Detail.route}/${pokemon.name}"
                )
            },
        contentAlignment = Alignment.Center,
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {

            Image(
                contentDescription = null,
                painter = rememberAsyncImagePainter(
                    model = getImageUrl(pokemon.url)
                ),
                modifier = Modifier.aspectRatio(1f)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                textAlign = TextAlign.Center,

                text = pokemon.name.capitalize(
                    Locale.current
                ),

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),

                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onSurface,
            )
        }
    }

}