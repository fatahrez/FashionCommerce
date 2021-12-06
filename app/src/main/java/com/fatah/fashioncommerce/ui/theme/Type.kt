package com.fatah.fashioncommerce.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.fatah.fashioncommerce.R

val readexProFonts = FontFamily(
    Font(R.font.readexpro_bold, FontWeight.Bold),
    Font(R.font.readexpro_extralight, FontWeight.ExtraLight),
    Font(R.font.readexpro_light, FontWeight.Light),
    Font(R.font.readexpro_medium, FontWeight.Medium),
    Font(R.font.readexpro_regular, FontWeight.Normal),
    Font(R.font.readexpro_semibold, FontWeight.SemiBold)
)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = readexProFonts,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    h1 = TextStyle(
        fontFamily = readexProFonts,
        fontWeight = FontWeight.SemiBold,
        fontSize = 50.sp
    ),

    overline = TextStyle(
        fontFamily = readexProFonts,
        fontWeight = FontWeight.SemiBold,
        fontSize = 50.sp,
        textDecoration = TextDecoration.LineThrough
    )

)