package com.mutualmobile.swiggy_clone.ui.screens.cart.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.common.composable.BackButton
import com.mutualmobile.swiggy_clone.common.composable.SpacerComponent
import com.mutualmobile.swiggy_clone.common.data.TipItem
import com.mutualmobile.swiggy_clone.domain.model.DMCartItem
import com.mutualmobile.swiggy_clone.navigator.ComposeNavigator
import com.mutualmobile.swiggy_clone.navigator.SwiggyScreen
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyBackgroundColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartItemsScreen(
    cartItems: List<DMCartItem>,
    tips: List<TipItem>,
    isExpanded: Boolean,
    composeNavigator: ComposeNavigator
) {

    var tip by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .height(dimensionResource(id = R.dimen.app_bar_height)),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.padding(8.dp)){
                    BackButton {}
                }
                SpacerComponent(dimensionResourceId = R.dimen.width_medium, isVertical = false)
                Text(text = "Hotel Empire")
            }
        },
        bottomBar = {
            BottomBar(onProceedClicked = {
                composeNavigator.navigate(SwiggyScreen.Confirm.route)
            }, price = "259", onViewDetailsClicked = {})
        }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
                .background(SwiggyBackgroundColor)
                .padding(it),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            if (isExpanded) CartScreenExpandedLayout(cartItems, tip, tips) { tip = it }
            else CartScreenCompactLayout(cartItems, tip, tips) { tip = it }
        }
    }
}

@Composable
fun CartScreenExpandedLayout(
    cartItems: List<DMCartItem>,
    tip: Int,
    tips: List<TipItem>,
    tipChangedCallback: (Int) -> Unit
) {
    Row {
       Column(modifier = Modifier
           .fillMaxWidth(.5f)
           .padding(dimensionResource(id = R.dimen.width_medium))) {
           CartItems(cartItems)
           DeliveryInstructions()
           BillDetails(190, 34, 0, tip, 259, onAddTipClicked = {
               tipChangedCallback(10)
           })
       }
       Column(modifier = Modifier
           .fillMaxWidth()
           .padding(dimensionResource(id = R.dimen.width_medium))) {
           ApplyCoupon()
           TipDeliveryPartner(tipValue = tip, onTipItemClicked = {
               tipChangedCallback(it)
           }, tips = tips)
       }

    }
    ReviewOrderPolicy()
    SpacerComponent(dimensionResourceId = R.dimen.scroll_view_padding_bottom)
}

@Composable
private fun CartScreenCompactLayout(
    cartItems: List<DMCartItem>,
    tip: Int,
    tips: List<TipItem>,
    tipChangedCallback: (Int) -> Unit
) {
    CartItems(cartItems)
    ApplyCoupon()
    TipDeliveryPartner(tipValue = tip, onTipItemClicked = {
        tipChangedCallback(it)
    }, tips = tips)
    DeliveryInstructions()
    BillDetails(190, 34, 0, tip, 259, onAddTipClicked = {
        tipChangedCallback(10)
    })
    ReviewOrderPolicy()
    SpacerComponent(dimensionResourceId = R.dimen.scroll_view_padding_bottom)
}