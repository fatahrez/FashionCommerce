package com.fatah.fashioncommerce

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fatah.fashioncommerce.models.BottomContentMenu
import com.fatah.fashioncommerce.ui.theme.ButtonBrown
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import java.util.*

@Composable
fun BottomMenu(
    items: List<BottomContentMenu>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBrown,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = Color.LightGray,
    initialSelectedItemIndex: Int = 0,
    navigator: DestinationsNavigator
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(10.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
                navigator = navigator,
                navigateTo = item.title.lowercase(Locale.getDefault()) + "_screen"
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomContentMenu,
    activeHighlightColor: Color = Color.Black,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = Color.LightGray,
    navigator: DestinationsNavigator,
    navigateTo: String,
    onItemClick:() ->Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable {
//                navController.navigate(navigateTo)
            }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .padding(12.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (item.active) activeHighlightColor else inactiveTextColor,
                modifier = Modifier.size(25.dp)
            )
        }
    }
}