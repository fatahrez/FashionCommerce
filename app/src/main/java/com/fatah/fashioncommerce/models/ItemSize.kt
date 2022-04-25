package com.fatah.fashioncommerce.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemSize(
    val name: String,
    val active: Boolean
):Parcelable
