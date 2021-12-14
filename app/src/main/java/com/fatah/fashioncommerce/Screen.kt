package com.fatah.fashioncommerce

sealed class Screen(val route: String) {
    object OnboardingPage : Screen("onboarding_page")
    object ProductListPage : Screen("product_list_page")
    object ProductDetailScreen : Screen("product_detail_page")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
