package com.fatah.fashioncommerce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.fatah.fashioncommerce.ui.theme.FashionCommerceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FashionCommerceTheme {
                Navigation()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}