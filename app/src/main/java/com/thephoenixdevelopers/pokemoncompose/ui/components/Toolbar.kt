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
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
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
    btnColor: Color = MaterialTheme.colors.onPrimary,
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


@Composable
fun ToolbarConstraint(
    backBtn: Boolean = false,
    title: String = String(),
    titleCenter: Boolean = false,
    navController: NavController,
    bgColor: Color = MaterialTheme.colors.primary,
    txtColor: Color = MaterialTheme.colors.onPrimary,
    btnColor: Color = MaterialTheme.colors.onPrimary,
) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(bgColor)
    ) {

        val (backButton, titleText) = createRefs()

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
                modifier = Modifier.constrainAs(backButton) {

                    width = Dimension.value(48.dp)
                    height = Dimension.value(48.dp)

                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                },
            )
        }

        Text(
            text = title,
            color = txtColor,
            style = MaterialTheme.typography.h1,
            modifier = Modifier.constrainAs(titleText) {

                width = Dimension.wrapContent
                height = Dimension.wrapContent

                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)

                when {
                    titleCenter -> {
                        end.linkTo(parent.end, 16.dp)
                        start.linkTo(parent.start, 16.dp)
                    }
                    else -> {

                        when {
                            backBtn -> {
                                start.linkTo(backButton.end, 16.dp)
                            }
                            else -> {
                                start.linkTo(parent.start, 16.dp)
                            }
                        }
                    }
                }
            },
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview(uiMode = UI_MODE_NIGHT_NO)
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

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun ToolbarConstraintPreview() {

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