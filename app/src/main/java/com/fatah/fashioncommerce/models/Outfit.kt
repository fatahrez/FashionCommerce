package com.fatah.fashioncommerce.models

import androidx.compose.ui.graphics.Color

data class Outfit(
    val image: String,
    val backgroundFillColor: Color,
    val name: String,
    val price: String
)