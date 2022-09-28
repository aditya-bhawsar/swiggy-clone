package com.mutualmobile.swiggy_clone.ui.screens.cart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.mutualmobile.swiggy_clone.domain.model.DMCartItem
import com.mutualmobile.swiggy_clone.ui.screens.cart.components.CartItemsScreen
import com.mutualmobile.swiggy_clone.ui.screens.cart.components.EmptyCartScreen
@Composable
fun CartScreen(
    viewModel: CartViewModel = hiltViewModel()
) {
    val tipsState by viewModel.tipInstructions.collectAsState()
    val tips by tipsState.collectAsState(initial = emptyList())

    val cartItems = listOf(
        DMCartItem(true, quantity = 1, "French fries", price = 125, 0L),
        DMCartItem(false, quantity = 2, "Chicken Burger", price = 200, 0L),
    )
    if (cartItems.size == 0) {
        EmptyCartScreen()
    } else if (cartItems.size > 0) {
        CartItemsScreen(cartItems = cartItems,tips = tips)
    }
}