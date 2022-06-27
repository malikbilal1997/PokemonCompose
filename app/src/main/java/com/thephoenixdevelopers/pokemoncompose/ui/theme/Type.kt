package com.thephoenixdevelopers.pokemoncompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.thephoenixdevelopers.pokemoncompose.R

// Set of Material typography styles to start with
val Typography = Typography(

    body1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.ubuntu_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    body2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.ubuntu_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),

    h1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.ubuntu_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),

    h2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.ubuntu_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),

    h3 = TextStyle(
        fontFamily = FontFamily(Font(R.font.ubuntu_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )

)