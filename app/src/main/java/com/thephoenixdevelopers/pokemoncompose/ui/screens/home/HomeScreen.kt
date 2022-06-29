package com.thephoenixdevelopers.pokemoncompose.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.thephoenixdevelopers.pokemoncompose.R
import com.thephoenixdevelopers.pokemoncompose.ui.components.PokemonGridItem
import com.thephoenixdevelopers.pokemoncompose.ui.components.Toolbar
import com.thephoenixdevelopers.pokemoncompose.ui.theme.Grey100
import com.thephoenixdevelopers.pokemoncompose.ui.theme.Grey900

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val itemList by rememberSaveable {
        viewModel.pokemonList
    }

    var loadMore by rememberSaveable {
        viewModel.moreLoading
    }

    val loadFirst by rememberSaveable {
        viewModel.firstLoading
    }

    var queryState by rememberSaveable {
        mutableStateOf(String())
    }

    val searchBoxBackgroundColor = when {
        isSystemInDarkTheme() -> {
            Grey900
        }
        else -> {
            Grey100
        }
    }

    var nothingFound by rememberSaveable {
        viewModel.nothingFound
    }


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
    ) {

        Column {

            Toolbar(
                backBtn = false,
                title = R.string.app_name,
                navController = navController,
                bgColor = MaterialTheme.colors.surface,
                txtColor = MaterialTheme.colors.onSurface,
                btnColor = MaterialTheme.colors.onSurface
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                lineHeight = 24.sp,
                text = stringResource(
                    id = R.string.search_text
                ),
                textAlign = TextAlign.Justify,

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),

                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(

                label = null,
                value = queryState,
                singleLine = true,
                placeholder = {
                    Text(
                        text = stringResource(
                            id = R.string.name_or_number
                        ),
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.onSurface
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = MaterialTheme.colors.onSurface
                    )
                },
                trailingIcon = {

                    if (queryState.isNotEmpty()) {

                        IconButton(
                            onClick = {
                                queryState = String()
                            },

                            content = {
                                Icon(
                                    imageVector = Icons.Rounded.Close,
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp),
                                    tint = MaterialTheme.colors.onSurface
                                )
                            }
                        )
                    }
                },
                onValueChange = {
                    queryState = it
                },
                shape = RoundedCornerShape(12.dp),
                textStyle = MaterialTheme.typography.body2,

                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(searchBoxBackgroundColor),

                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = MaterialTheme.colors.onSurface
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(modifier = Modifier.fillMaxSize()) {

                if (loadFirst) {

                    CircularProgressIndicator(
                        color = MaterialTheme.colors.onSurface,
                        modifier = Modifier.align(Alignment.Center)
                    )

                } else {

                    LazyVerticalGrid(
                        modifier = Modifier.fillMaxSize(),
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {

                        items(itemList.size) { currentItem ->

                            if (currentItem >= itemList.size - 1) {
                                viewModel.fetchPokemonList()
                            }

                            PokemonGridItem(
                                pokemon = itemList[currentItem],
                                navController = navController
                            )

                        }
                    }

                }

            }

        }
    }
}
