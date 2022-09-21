package com.mutualmobile.swiggy_clone.ui.screens.cart.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.data.local.model.CartItem
import com.mutualmobile.swiggy_clone.ui.common_composables.QuantityIncrementer

@Composable
fun CartItems(cartItems:List<CartItem>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
    ) {
        cartItems.forEach { cartItem ->
            CartListItem(cartItem = cartItem)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.write_instructions),
                style = MaterialTheme.typography.bodySmall
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_add_circle_outline),
                contentDescription = ""
            )
        }
    }
}

@Composable
fun CartListItem(cartItem: CartItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = if (cartItem.isVegetarian) painterResource(id = R.drawable.veg) else painterResource(
                    id = R.drawable.non_veg
                ), contentDescription = "",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = cartItem.title, style = MaterialTheme.typography.bodySmall)
        }
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            QuantityIncrementer(value = cartItem.quantity, onIncrement = { }, onDecrement = {})
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "₹${cartItem.price}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}