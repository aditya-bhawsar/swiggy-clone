package com.mutualmobile.swiggy_clone.ui.screens.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.data.local.model.CartItem
import com.mutualmobile.swiggy_clone.ui.common_composables.BackButton
import com.mutualmobile.swiggy_clone.ui.screens.cart.components.ApplyCoupon
import com.mutualmobile.swiggy_clone.ui.screens.cart.components.BillDetails
import com.mutualmobile.swiggy_clone.ui.screens.cart.components.BottomBar
import com.mutualmobile.swiggy_clone.ui.screens.cart.components.CartItems
import com.mutualmobile.swiggy_clone.ui.screens.cart.components.DeliveryInstructions
import com.mutualmobile.swiggy_clone.ui.screens.cart.components.EmptyCartScreen
import com.mutualmobile.swiggy_clone.ui.screens.cart.components.ReviewOrderPolicy
import com.mutualmobile.swiggy_clone.ui.screens.cart.components.TipDeliveryPartner
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyBackgroundColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen() {
    val scaffoldState = rememberScaffoldState()

    val cartItems = listOf(
        CartItem(true, quantity = 1, "French fries", price = 125, 0L),
        CartItem(false, quantity = 2, "Chicken Burger", price = 200, 0L),
    )

    var tip by remember {
        mutableStateOf(0)
    }

    if (cartItems.size == 0) {
        EmptyCartScreen()
    } else if (cartItems.size > 0) {
        Scaffold(scaffoldState = scaffoldState,
            topBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BackButton {

                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Hotel Empire")
                }
            },
            bottomBar = {
                BottomBar(onProceedClick = { }, price = "259", onViewDetailedClick = {})
            }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
                    .background(SwiggyBackgroundColor)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {


                CartItems(cartItems)
                ApplyCoupon()
                TipDeliveryPartner(tipValue = tip, onTipItemClicked = {
                    tip = it
                })
                DeliveryInstructions()
                BillDetails(190, 34, 0, tip, 259, onAddTipClicked = {
                    tip = 10
                })
                ReviewOrderPolicy()
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}