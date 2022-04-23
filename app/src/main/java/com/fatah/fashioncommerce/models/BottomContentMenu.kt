package com.fatah.fashioncommerce.models

import androidx.annotation.DrawableRes

data class BottomContentMenu(
    val title: String,
    @DrawableRes val iconId: Int,
    val active: Boolean
)
