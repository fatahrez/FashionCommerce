package com.fatah.fashioncommerce

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.fatah.fashioncommerce.models.Collection
import com.fatah.fashioncommerce.models.Outfit
import com.fatah.fashioncommerce.ui.theme.ButtonBrown
import com.fatah.fashioncommerce.ui.theme.GreyHighlightColor
import com.fatah.fashioncommerce.ui.theme.SmokeWhiteBackground
import com.fatah.fashioncommerce.ui.theme.readexProFonts

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
            LazyColumn{
                item {
                    MenuSearchArea()
                    Spacer(modifier = Modifier.padding(8.dp))
                    NewArrivalArea()
                    NewArrivalOutfitsArea(outfits =
                        listOf(
                            Outfit(
                                "https://image.uniqlo.com/UQ/ST3/WesternCommon/imagesgoods/441600/item/goods_30_441600.jpg",
                                Color(0xFFFFFFFF),
                                "Short-Sleeve T-Shirt",
                                "$60.99"
                            ),
                            Outfit(
                                "https://image.uniqlo.com/UQ/ST3/WesternCommon/imagesgoods/447656/sub/goods_447656_sub13.jpg",
                                Color(0xFFFFFFFF),
                                "Skinny-Fit Jeans (Tall)",
                                "$49.90"
                            )
                        )
                    )
                    CollectionArea()
                    CollectionsListArea(
                        listOf(
                            Collection(
                                "SPRING",
                                "https://images.unsplash.com/photo-1462275646964-a0e3386b89fa?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2456&q=80",
                                GreyHighlightColor
                            ),
                            Collection(
                                "WINTER",
                                "https://images.unsplash.com/photo-1484313544071-4d67c88b99be?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2372&q=80",
                                GreyHighlightColor
                            ),
                            Collection(
                                "SUMMER",
                                "https://images.unsplash.com/photo-1542213493895-edf5b94f5a96?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2146&q=80",
                                GreyHighlightColor
                            )
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun MenuSearchArea() {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ){
        val menuPainter = painterResource(id = R.drawable.hamburger)

        Button (
            onClick = {},
            colors = ButtonDefaults.buttonColors(contentColor = Color.Black, backgroundColor = Color.White),
            shape = RoundedCornerShape(25),
            contentPadding = PaddingValues(9.dp),
            modifier = Modifier
                .size(35.dp)
        ){
            Icon(
                painter = menuPainter,
                contentDescription = "menu"
            )
        }

        val searchPainter = painterResource(id = R.drawable.search)

        Button (
            onClick = {},
            colors = ButtonDefaults.buttonColors(contentColor = Color.Black, backgroundColor = Color.White),
            shape = RoundedCornerShape(25),
            contentPadding = PaddingValues(10.dp),
            modifier = Modifier
                .size(35.dp)
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
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "New Arrival",
            style = TextStyle(
                fontFamily = readexProFonts,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
            )
        )
        Text(
            text = "See all",
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(top = 9.5.dp)
        )
    }
}

@Composable
fun NewArrivalOutfitsArea(
    outfits: List<Outfit>
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val cardWidth = screenWidth/2f
    val cardHeight = screenHeight/ 2.5f
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(cardHeight)
    ) {
        items(outfits.size) {
            OutfitCard(
                outfit = outfits[it],
                cardWidth = cardWidth,
                cardHeight = cardHeight
            )
        }
    }
}

@Composable
fun OutfitCard(
    outfit: Outfit,
    cardWidth: Dp,
    cardHeight: Dp
) {
    Card(
        modifier = Modifier
            .width(cardWidth * 1.2f)
            .padding(start = 2.dp, end = 30.dp, bottom = 0.dp, top = 8.dp)
            .clickable { },
        shape = RoundedCornerShape(6),
        elevation = 4.dp
    ) {
        Column {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height((cardHeight / 3) * 2.2f)
                .clip(RoundedCornerShape(14))
                .padding(6.dp)
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = outfit.image
                    ),
                    contentDescription = outfit.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxHeight()
                )
            }
            Row(
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = outfit.name,
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = outfit.price,
                        style = MaterialTheme.typography.caption
                    )
                }
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    modifier= Modifier.size(30.dp),
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = ButtonBrown),
                    elevation = ButtonDefaults.elevation(4.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.heart),
                        contentDescription = "heart button",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(7.dp)
                    )
                }
            }

        }
    }
}

@Composable
fun CollectionArea() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "Collection",
            style = TextStyle(
                fontFamily = readexProFonts,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
            )
        )
        Text(
            text = "See all",
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(top = 9.5.dp)
        )
    }
}

@Composable
fun CollectionsListArea(
    collections: List<Collection>
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val cardHeight = screenHeight/5
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(cardHeight)
    ) {
        items(collections.size){
            CollectionCardArea(
                collection = collections[it],
                screenWidth/3
            )
        }
    }
}

@Composable
fun CollectionCardArea(
    collection: Collection,
    cardWidth: Dp
) {
    Card(
        modifier = Modifier
            .width(cardWidth)
            .padding(start = 2.dp, end = 25.dp, bottom = 5.dp, top = 0.dp)
            .clickable { },
        shape = RoundedCornerShape(6),
        elevation = 4.dp,
    ) {
        Box(modifier = Modifier
            .fillMaxSize(),
        ) {
            Image(
                painter = rememberImagePainter(
                    data = collection.image
                ),
                contentDescription = collection.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Text(text = collection.name, color = Color.White)
    }
}