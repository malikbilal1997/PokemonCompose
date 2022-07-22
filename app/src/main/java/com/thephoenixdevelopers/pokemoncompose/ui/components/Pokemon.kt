package com.thephoenixdevelopers.pokemoncompose.ui.components

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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.thephoenixdevelopers.pokemoncompose.data.pokemon.list.Pokemon
import com.thephoenixdevelopers.pokemoncompose.ui.navigation.Screen
import com.thephoenixdevelopers.pokemoncompose.ui.theme.Grey100
import com.thephoenixdevelopers.pokemoncompose.ui.theme.Grey900
import com.thephoenixdevelopers.pokemoncompose.utils.PokemonImageUtil.getDefaultImageUrl
import java.net.URLEncoder
import java.nio.charset.StandardCharsets.UTF_8


@Composable
fun PokemonGridItem(
    pokemon: Pokemon = Pokemon(),
    navController: NavController,
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

                val encodedUrl = URLEncoder.encode(
                    pokemon.url, UTF_8.toString()
                )

                val parameters = "${encodedUrl}/${pokemon.name}"

                navController.navigate(
                    "${Screen.Detail.route}/$parameters"
                )
            },
        contentAlignment = Alignment.Center,
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {

            SubcomposeAsyncImage(
                contentDescription = null,
                model = getDefaultImageUrl(pokemon.url),
                modifier = Modifier.aspectRatio(1f)
            ) {

                when (painter.state) {

                    is AsyncImagePainter.State.Success -> {
                        SubcomposeAsyncImageContent()
                    }

                    is AsyncImagePainter.State.Loading -> {
                        ImageProgress(
                            progressBarSize = 24.dp,
                            progressBarStroke = 2.dp,
                            progressBarColor = MaterialTheme.colors.onSurface,
                            modifier = Modifier
                        )
                    }

                    else -> Unit
                }

            }

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

@Composable
fun PokemonSpriteItem(
    spriteBoxSize: Dp = 120.dp,
    spriteImgSize: Dp = 64.dp,
    imageUrl: String = String(),
) {

    Box(
        modifier = Modifier
            .size(spriteBoxSize)
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
            ),

        contentAlignment = Alignment.Center,
    ) {

        SubcomposeAsyncImage(
            contentDescription = null,
            model = imageUrl,
            modifier = Modifier
                .size(spriteImgSize)
        ) {

            when (painter.state) {

                is AsyncImagePainter.State.Success -> {
                    SubcomposeAsyncImageContent()
                }

                is AsyncImagePainter.State.Loading -> {
                    ImageProgress(
                        modifier = Modifier,
                        progressBarSize = 24.dp,
                        progressBarStroke = 2.dp,
                        progressBarColor = MaterialTheme.colors.onSurface,
                    )
                }

                else -> Unit
            }

        }

    }

}