package com.fatah.fashioncommerce

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.OnboardingPage.route) {
        composable(route = Screen.OnboardingPage.route) {
            OnboardingPage(navController = navController, arrivals = 44)
        }
        composable(
            route = Screen.ProductListPage.route
        ) {
            ProductListPage(navController = navController)
        }
    }
}