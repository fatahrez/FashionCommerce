package com.fatah.fashioncommerce.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemColor(
    val color: String,
    val active: Boolean = false,
): Parcelable
