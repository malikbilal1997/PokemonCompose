package com.thephoenixdevelopers.pokemoncompose.ui.screens.detail

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Height
import androidx.compose.material.icons.rounded.Scale
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.thephoenixdevelopers.pokemoncompose.R
import com.thephoenixdevelopers.pokemoncompose.ui.components.ImageProgress
import com.thephoenixdevelopers.pokemoncompose.ui.components.PokemonSpriteItem
import com.thephoenixdevelopers.pokemoncompose.ui.components.ProgressCircle
import com.thephoenixdevelopers.pokemoncompose.ui.components.Toolbar
import com.thephoenixdevelopers.pokemoncompose.ui.theme.Grey100
import com.thephoenixdevelopers.pokemoncompose.ui.theme.Grey900
import com.thephoenixdevelopers.pokemoncompose.utils.PokemonImageUtil.getHighResImageUrl

@Composable
fun DetailScreen(
    pokemonUrl: String = String(),
    pokemonName: String = String(),
    navController: NavController,
    viewModel: DetailViewModel = hiltViewModel(),
) {
    val scrollState = rememberScrollState()

    val loadingError by rememberSaveable { viewModel.loadingError }

    val pokemonDetails by rememberSaveable { viewModel.pokemonDetails }

    val loadingDetails by rememberSaveable { viewModel.loadingDetails }

    LaunchedEffect(key1 = true) {
        viewModel.getPokemonDetails(pokemonName)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
    ) {

        Box(modifier = Modifier.fillMaxSize()) {

            // Showing Progress Bar on Loading of Items First Time
            if (loadingDetails) {

                ProgressCircle(
                    progressBarSize = 36.dp,
                    progressBarStroke = 2.dp,
                    progressBarColor = MaterialTheme.colors.onSurface,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            if (loadingError) {

                Text(
                    lineHeight = 24.sp,
                    text = stringResource(
                        id = R.string.load_error
                    ),
                    textAlign = TextAlign.Center,

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .align(Alignment.Center),

                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                )
            }


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {

                Toolbar(
                    backBtn = true,
                    titleCenter = true,
                    navController = navController,
                    title = pokemonName.capitalize(
                        Locale.current
                    ),
                    bgColor = MaterialTheme.colors.surface,
                    txtColor = MaterialTheme.colors.onSurface,
                    btnColor = MaterialTheme.colors.onSurface
                )

                Spacer(modifier = Modifier.height(8.dp))

                // If It's not Loading and there's nor Error

                if (!loadingDetails && !loadingError) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
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
                            model = getHighResImageUrl(
                                pokemonUrl
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .aspectRatio(1f)
                        ) {

                            when (painter.state) {

                                is AsyncImagePainter.State.Success -> {
                                    SubcomposeAsyncImageContent()
                                }

                                is AsyncImagePainter.State.Loading -> {
                                    ImageProgress(
                                        progressBarSize = 36.dp,
                                        progressBarStroke = 2.dp,
                                        progressBarColor = MaterialTheme.colors.onSurface,
                                        modifier = Modifier
                                    )
                                }

                                else -> Unit
                            }

                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(when {
                                isSystemInDarkTheme() -> {
                                    Grey900
                                }
                                else -> {
                                    Grey100
                                }
                            })
                            .padding(vertical = 16.dp)

                    ) {

                        Row(
                            modifier = Modifier.weight(1f),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Image(
                                contentDescription = null,
                                imageVector = Icons.Rounded.Scale,
                                modifier = Modifier.size(32.dp),
                                colorFilter = ColorFilter.tint(
                                    MaterialTheme.colors.onSurface
                                )
                            )

                            Spacer(modifier = Modifier.width(4.dp))

                            Text(
                                text = stringResource(
                                    id = R.string.weight,
                                    (pokemonDetails.weight / 10f)
                                ),
                                style = MaterialTheme.typography.body2,
                                color = MaterialTheme.colors.onSurface,
                            )

                        }

                        Row(
                            modifier = Modifier.weight(1f),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Image(
                                contentDescription = null,
                                imageVector = Icons.Rounded.Height,
                                modifier = Modifier.size(32.dp),
                                colorFilter = ColorFilter.tint(
                                    MaterialTheme.colors.onSurface
                                )
                            )


                            Spacer(modifier = Modifier.width(4.dp))

                            Text(
                                text = stringResource(
                                    id = R.string.height,
                                    (pokemonDetails.height / 10f)
                                ),
                                style = MaterialTheme.typography.body2,
                                color = MaterialTheme.colors.onSurface,
                            )

                        }

                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {

                        val sprites = pokemonDetails.sprites.getSpriteList()

                        items(sprites) { currentItem ->

                            PokemonSpriteItem(
                                imageUrl = currentItem,
                                spriteBoxSize = 120.dp,
                                spriteImgSize = 96.dp
                            )
                        }

                    }

                }
            }
        }
    }
}