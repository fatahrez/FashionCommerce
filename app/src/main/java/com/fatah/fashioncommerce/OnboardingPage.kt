package com.fatah.fashioncommerce

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fatah.fashioncommerce.ui.theme.ButtonBrown
import com.fatah.fashioncommerce.ui.theme.GreyHighlightColor

@Composable
fun OnboardingPage(
    arrivals: Int,
    navController: NavController
) {
    Image(
        painter = painterResource(id = R.drawable.woman_fashion),
        contentScale = ContentScale.Crop,
        contentDescription = "background",
        modifier = Modifier.fillMaxSize()
    )
   Box(
       modifier = Modifier
           .fillMaxSize()
           .padding(32.dp)
   ) {
       NewArrivals(arrivals = arrivals)
       BottomSection(navController)
   }
}

@Composable
fun NewArrivals(
    arrivals: Int
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20))
            .background(GreyHighlightColor.copy(alpha = 0.6f))
            .wrapContentSize()
            .padding(15.dp),
        contentAlignment = Alignment.TopStart
    ) {
        Text("$arrivals new arrivals 🔥", color = Color.White)
    }
}

@Composable
fun BottomSection(
    navController: NavController
) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxSize()
            .offset(y = 170.dp)
    ) {
        Column {
            Row {
                Text(
                    "With ",
                    color = Color.White,
                    style = MaterialTheme.typography.h1
                )

                Text(
                    "old ",
                    color = Color.White,
                    style = MaterialTheme.typography.overline
                )

                Text(
                    "new ",
                    color = Color.White,
                    style = MaterialTheme.typography.h1
                )
            }

            Text(
                "clothes",
                color = Color.White,
                style = MaterialTheme.typography.h1
            )

            Spacer(modifier = Modifier.padding(16.dp))

            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = "Skip",
                    style = MaterialTheme.typography.body1,
                    color = Color.White,
                    modifier = Modifier.clickable {  }
                )

                Button(
                    onClick = {
                       navController.navigate(Screen.ProductListPage.route)
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White, backgroundColor = ButtonBrown
                    ),
                    shape = RoundedCornerShape(30),
                    modifier = Modifier
                        .height(56.dp)
                ) {
                    val arrowPainter = painterResource(id = R.drawable.outline_arrow_right_alt_24)
                    Icon(
                        painter = arrowPainter,
                        contentDescription = "arrow right",
                        modifier = Modifier
                            .size(35.dp)
                            .clip(RoundedCornerShape(50))
                            .background(Color.White.copy(alpha = 0.65f))
                            .padding(4.dp)

                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text = "Get Started",
                        style = MaterialTheme.typography.body1
                    )
                }
            }
        }
    }
}