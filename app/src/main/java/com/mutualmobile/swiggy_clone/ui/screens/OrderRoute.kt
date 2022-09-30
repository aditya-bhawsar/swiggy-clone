package com.mutualmobile.swiggy_clone.ui.screens

import ConfirmationScreen
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.mutualmobile.swiggy_clone.navigator.ComposeNavigator
import com.mutualmobile.swiggy_clone.navigator.SwiggyRoute
import com.mutualmobile.swiggy_clone.navigator.SwiggyScreen
import com.mutualmobile.swiggy_clone.ui.screens.cart.CartScreen
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import com.mutualmobile.swiggy_clone.ui.screens.coupon.ApplyCouponScreen
import com.mutualmobile.swiggy_clone.ui.screens.food.FoodScreen
import com.mutualmobile.swiggy_clone.ui.screens.search.SearchScreen

fun NavGraphBuilder.orderRoute(
    composeNavigator: ComposeNavigator,
    widthSizeClass: WindowWidthSizeClass,
) {
    navigation(
        startDestination = SwiggyScreen.Food.name,
        route = SwiggyRoute.Order.name
    ) {
        composable(SwiggyScreen.Cart.name) {
            CartScreen(composeNavigator = composeNavigator, widthSizeClass = widthSizeClass)
        }
        composable(SwiggyScreen.Confirm.name) {
            ConfirmationScreen(
                composeNavigator = composeNavigator,
                widthSizeClass = widthSizeClass
            )
        }
        composable(SwiggyScreen.Search.name) {
            SearchScreen(
                composeNavigator = composeNavigator,
                widthSizeClass = widthSizeClass,
                forRestaurant = false
            )
        }
        composable(SwiggyScreen.ApplyCoupon.name) {
            ApplyCouponScreen(composeNavigator = composeNavigator, widthSizeClass = widthSizeClass)
        }
        composable(SwiggyScreen.Food.name) {
            FoodScreen(composeNavigator = composeNavigator ,widthSizeClass = widthSizeClass)
        }
    }

}