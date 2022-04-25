package com.fatah.fashioncommerce

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import coil.compose.rememberImagePainter
import com.fatah.fashioncommerce.destinations.ProductListPageDestination
import com.fatah.fashioncommerce.models.Outfit
import com.fatah.fashioncommerce.ui.theme.ButtonBrown
import com.fatah.fashioncommerce.ui.theme.GreyText
import com.fatah.fashioncommerce.ui.theme.SmokeWhiteBackground
import com.fatah.fashioncommerce.ui.theme.readexProFonts
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ProductDetailPage(
    navigator: DestinationsNavigator,
    outfit: Outfit
) {
    Box(
        modifier = Modifier
            .background(SmokeWhiteBackground)
            .fillMaxSize()
    ) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                MenuCartArea(navigator = navigator)
                ProductNameArea(outfit = outfit)
                ProductImageArea(outfit = outfit)
                Spacer(modifier = Modifier.size(16.dp))
                ColorListArea(outfit = outfit)
                Spacer(modifier = Modifier.size(24.dp))
                CartAndPriceArea(outfit = outfit)
            }
        }
    }

}

@Composable
fun MenuCartArea(
    navigator: DestinationsNavigator
) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ){
        val menuPainter = painterResource(id = R.drawable.left_arrow)

        Button (
            onClick = {
              navigator.navigate(ProductListPageDestination())
            },
            colors = ButtonDefaults.buttonColors(contentColor = Color.Black, backgroundColor = Color.White),
            shape = RoundedCornerShape(25),
            contentPadding = PaddingValues(9.dp),
            modifier = Modifier
                .size(35.dp)
        ){
            Icon(
                painter = menuPainter,
                contentDescription = "back button"
            )
        }

        val searchPainter = painterResource(id = R.drawable.shopping_bag)

        Button (
            onClick = {},
            colors = ButtonDefaults.buttonColors(contentColor = Color.Black, backgroundColor = Color.White),
            shape = RoundedCornerShape(25),
            contentPadding = PaddingValues(10.dp),
            modifier = Modifier
                .size(35.dp)
        ){
            BadgedBox(badge = { Badge(backgroundColor = ButtonBrown) { Text(text = "2") } }) {
                Icon(
                    painter = searchPainter,
                    contentDescription = "Cart button",
                )
            }
        }
    }
}

@Composable
fun ProductNameArea(
    outfit: Outfit
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
        ) {
            Text(
                text = outfit.name,
                style = TextStyle(
                    fontFamily = readexProFonts,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }

        Box(modifier = Modifier
            .fillMaxWidth()
        ) {
            Text(
                text = outfit.type,
                style = MaterialTheme.typography.subtitle2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }

}

@Composable
fun ProductImageArea(
    outfit: Outfit
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val imageHeight = screenHeight/2

    Row (modifier = Modifier
        .height(imageHeight)
        .fillMaxWidth()
        .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Card(
            modifier = Modifier
                .width(screenWidth / 1.5f)
                .clip(RoundedCornerShape(10)),
            elevation = 10.dp
        ) {
            Image(
                painter = rememberImagePainter(data = outfit.image),
                contentDescription = outfit.name,
                contentScale = ContentScale.FillHeight
            )
        }

        Box(modifier = Modifier.clip(RoundedCornerShape(50))) {
            LazyColumn(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxHeight()
                    .width(50.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(outfit.sizes.size) {i ->
                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(100))
                        .background(if (outfit.sizes[i].active) ButtonBrown else Color.White)

                    ) {
                        Text(
                            text = outfit.sizes[i].name,
                            modifier = Modifier
                                .padding(14.dp)
                                .clickable { },
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.subtitle2,
                        )

                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ColorListArea(
    outfit: Outfit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items(outfit.colors.size) {
            Card(modifier = Modifier
                .size(45.dp),
                shape = RoundedCornerShape(20),
                onClick = { }
            ) {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    if (!outfit.colors[it].active) {
                        Donut(Color(outfit.colors[it].color.toColorInt()))
                    } else {
                        androidx.compose.foundation.Canvas(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Transparent),
                            onDraw = {
                                drawCircle(
                                    color = Color(outfit.colors[it].color.toColorInt()),
                                    radius = size.width/1.8f
                                )
                            }
                        )
                    }
                }

            }

        }
    }
}

@Composable
fun Donut(
    color: Color
) {
    androidx.compose.foundation.Canvas(modifier = Modifier
        .fillMaxSize()
        .background(Color.Transparent)
    ) {
        val width = size.width
        val height = size.height
        drawArc(
            color = color,
            startAngle = 0f,
            sweepAngle = 360f,
            useCenter = false,
            size = Size(width = width, height = height),
            style = Stroke(
                width = 20f
            )
        )
    }
}

@Composable
fun CartAndPriceArea(
    outfit: Outfit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, bottom = 4.dp)
        ) {
            Text(
                text = "Price",
                style = TextStyle(
                    fontFamily = readexProFonts,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = GreyText
                )
            )
            Text(
                text = outfit.price,
                style = MaterialTheme.typography.body1
            )
        }

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White, backgroundColor = ButtonBrown
            ),
            shape = RoundedCornerShape(30),
            modifier = Modifier
                .height(56.dp)
        ) {
            val arrowPainter = painterResource(id = R.drawable.shopping_bag)
            Icon(
                painter = arrowPainter,
                contentDescription = "Cart Icon",
                modifier = Modifier
                    .size(30.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color.White.copy(alpha = 0.65f))
                    .padding(8.dp)

            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "Add to cart",
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Preview
@Composable
fun DonutPreview() {
    Donut(color = Color.Black)
}