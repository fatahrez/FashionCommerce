package com.fatah.fashioncommerce.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Outfit(
    val image: String,
    val name: String,
    val price: String,
    val type: String,
    val sizes: List<ItemSize>,
    val colors: List<ItemColor>
): Parcelable