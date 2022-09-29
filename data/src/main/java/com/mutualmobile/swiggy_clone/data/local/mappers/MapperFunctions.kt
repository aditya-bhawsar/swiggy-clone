package com.mutualmobile.swiggy_clone.data.local.mappers

import com.mutualmobile.swiggy_clone.data.local.model.CartItem
import com.mutualmobile.swiggy_clone.domain.model.DMCartItem

object MapperFunctions {
    fun DMCartItem.toCartItem(): CartItem {
        return CartItem(
            isVegetarian = this.isVegetarian,
            quantity = this.quantity,
            title = this.title,
            price = this.price,
            cartItemId = this.cartItemId
        )
    }

    fun CartItem.toDmCartItem(): DMCartItem {
        return DMCartItem(
            isVegetarian = this.isVegetarian,
            quantity = this.quantity,
            title = this.title,
            price = this.price,
            cartItemId = this.cartItemId
        )
    }
}