package com.mutualmobile.swiggy_clone.domain.model

data class DMCartItem(
    val isVegetarian: Boolean,
    val quantity: Int = 1,
    val title: String,
    val price: Int,
    val cartItemId: Long = 0L,
)
