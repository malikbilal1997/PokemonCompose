package com.thephoenixdevelopers.pokemoncompose.ui.screens.detail

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.thephoenixdevelopers.pokemoncompose.ui.components.Toolbar
import com.thephoenixdevelopers.pokemoncompose.ui.navigation.Screen
import com.thephoenixdevelopers.pokemoncompose.ui.theme.Grey100
import com.thephoenixdevelopers.pokemoncompose.ui.theme.Grey900
import com.thephoenixdevelopers.pokemoncompose.ui.theme.PokedexTheme
import com.thephoenixdevelopers.pokemoncompose.utils.PokemonImageUtil

@Composable
fun DetailScreen(
    pokemonUrl: String = String(),
    pokemonName: String = String(),
    navController: NavController,
    viewModel: DetailViewModel = hiltViewModel()
) {

    val scrollState = rememberScrollState()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
    ) {

        Box(modifier = Modifier.fillMaxSize()) {

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

                Box(
                    modifier = Modifier
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

                    Image(
                        contentDescription = null,
                        painter = rememberAsyncImagePainter(
                            model = PokemonImageUtil.getImageUrl(pokemonUrl)
                        ),
                        modifier = Modifier.aspectRatio(1f)
                    )
                }
            }
        }
    }
}