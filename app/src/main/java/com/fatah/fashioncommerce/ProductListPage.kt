package com.fatah.fashioncommerce

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fatah.fashioncommerce.ui.theme.SmokeWhiteBackground

@Composable
fun ProductListPage(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .background(SmokeWhiteBackground)
            .fillMaxSize()
    ) {
        Box(
            Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            MenuSearchArea()
        }
    }
}

@Composable
fun MenuSearchArea() {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ){
        val menuPainter = painterResource(id = R.drawable.hamburger)

        Box (
            modifier = Modifier
                .size(42.dp)
                .padding(12.dp)
                .background(Color.White)
        ){
            Icon(
                painter = menuPainter,
                contentDescription = "menu"
            )
        }

        val searchPainter = painterResource(id = R.drawable.search)

        Box (
            modifier = Modifier
                .size(42.dp)
                .padding(12.dp)
                .background(Color.White)
        ){
            Icon(
                painter = searchPainter,
                contentDescription = "search",
            )
        }
    }
}

@Composable
fun NewArrivalArea() {
    
}