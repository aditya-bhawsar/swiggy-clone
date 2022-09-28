package com.mutualmobile.swiggy_clone.ui.screens.cart.components

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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.common.composable.BackButton
import com.mutualmobile.swiggy_clone.common.composable.SpacerComponent
import com.mutualmobile.swiggy_clone.common.data.TipItem
import com.mutualmobile.swiggy_clone.domain.model.DMCartItem
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyBackgroundColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartItemsScreen(cartItems: List<DMCartItem>, tips: List<TipItem>) {

    val scaffoldState = rememberScaffoldState()

    var tip by remember {
        mutableStateOf(0)
    }

    Scaffold(scaffoldState = scaffoldState,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.app_bar_height)),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackButton {

                }
                SpacerComponent(dimensionResourceId = R.dimen.width_medium, isVertical = false)
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
                .padding(dimensionResource(id = R.dimen.padding_large)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            CartItems(cartItems)
            ApplyCoupon()
            TipDeliveryPartner(tipValue = tip, onTipItemClicked = {
                tip = it
            }, tips = tips)
            DeliveryInstructions()
            BillDetails(190, 34, 0, tip, 259, onAddTipClicked = {
                tip = 10
            })
            ReviewOrderPolicy()
            SpacerComponent(dimensionResourceId = R.dimen.scroll_view_padding_bottom)
        }
    }
}