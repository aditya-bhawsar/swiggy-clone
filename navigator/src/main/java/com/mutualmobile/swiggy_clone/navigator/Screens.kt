package com.mutualmobile.swiggy_clone.navigator

import androidx.navigation.NamedNavArgument

sealed class SwiggyScreen(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    val name: String = route.appendArguments(navArguments)

    object Cart: SwiggyScreen("cart")
    object Confirm: SwiggyScreen("checkout")
    object Search: SwiggyScreen("search")
    object ApplyCoupon: SwiggyScreen("coupon")
    object Food: SwiggyScreen("food")
    object Splash: SwiggyScreen("splash")
    object Payment: SwiggyScreen("pay")
    object Menu: SwiggyScreen("menu")
}

sealed class SwiggyRoute(val name: String) {
    object Order : SwiggyRoute("orderRoute")
}

private fun String.appendArguments(navArguments: List<NamedNavArgument>): String {
    val mandatoryArguments = navArguments.filter { it.argument.defaultValue == null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }
        .orEmpty()
    val optionalArguments = navArguments.filter { it.argument.defaultValue != null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }
        .orEmpty()
    return "$this$mandatoryArguments$optionalArguments"
}