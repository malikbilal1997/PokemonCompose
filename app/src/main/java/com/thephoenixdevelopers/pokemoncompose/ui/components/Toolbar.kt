package com.thephoenixdevelopers.pokemoncompose.ui.components


import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thephoenixdevelopers.pokemoncompose.R
import com.thephoenixdevelopers.pokemoncompose.ui.theme.PokedexTheme

@Composable
fun Toolbar(
    backBtn: Boolean = false,
    title: String = String(),
    titleCenter: Boolean = false,
    navController: NavController,
    bgColor: Color = MaterialTheme.colors.primary,
    txtColor: Color = MaterialTheme.colors.onPrimary,
    btnColor: Color = MaterialTheme.colors.onPrimary
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(bgColor),
    ) {

        if (backBtn) {

            IconButton(
                onClick = {
                    navController.popBackStack()
                },
                content = {
                    Icon(
                        tint = btnColor,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Rounded.ArrowBack
                    )
                },
                modifier = Modifier
                    .size(48.dp)
                    .align(CenterStart),
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Center)
        ) {

            Text(
                text = title,
                color = txtColor,
                modifier = Modifier
                    .align(
                        when {
                            titleCenter -> {
                                Center
                            }
                            else -> {
                                CenterStart
                            }
                        }
                    )
                    .padding(

                        horizontal = when {
                            backBtn -> {
                                64.dp
                            }
                            else -> {
                                16.dp
                            }
                        }
                    ),
                style = MaterialTheme.typography.h1
            )
        }
    }

}


@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun ToolbarPreview() {

    PokedexTheme {
        Toolbar(
            backBtn = true,
            titleCenter = true,
            title = stringResource(
                id = R.string.app_name
            ),
            navController = rememberNavController(),
            bgColor = MaterialTheme.colors.surface,
            txtColor = MaterialTheme.colors.onSurface,
            btnColor = MaterialTheme.colors.onSurface
        )
    }

}