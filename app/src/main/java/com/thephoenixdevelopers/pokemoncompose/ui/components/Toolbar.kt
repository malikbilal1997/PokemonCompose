package com.thephoenixdevelopers.pokemoncompose.ui.components


import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.thephoenixdevelopers.pokemoncompose.R
import com.thephoenixdevelopers.pokemoncompose.ui.theme.PokedexTheme

@Composable
fun Toolbar(
    @StringRes title: Int,
    backBtn: Boolean = false,
    navController: NavController,
    bgColor: Color = MaterialTheme.colors.primary,
    txtColor: Color = MaterialTheme.colors.onPrimary,
    btnColor: Color = MaterialTheme.colors.onPrimary
) {
    Box {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(bgColor),
            verticalAlignment = CenterVertically,

            ) {

            if (backBtn) {

                IconButton(
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp),

                    content = {
                        Icon(
                            tint = btnColor,
                            modifier = Modifier
                                .width(24.dp)
                                .height(24.dp),
                            contentDescription = null,
                            imageVector = Icons.Rounded.ArrowBack
                        )
                    },

                    onClick = {
                        navController.popBackStack()
                    }
                )
            }

            Text(

                color = txtColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp),
                text = stringResource(id = title),
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
            title = R.string.app_name, backBtn = true,
            navController = rememberNavController(),
            bgColor = MaterialTheme.colors.surface,
            txtColor = MaterialTheme.colors.onSurface,
            btnColor = MaterialTheme.colors.onSurface
        )
    }

}