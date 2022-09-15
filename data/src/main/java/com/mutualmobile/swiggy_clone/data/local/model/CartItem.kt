package com.mutualmobile.swiggy_clone.data.local.model

import androidx.room.PrimaryKey

data class CartItem(
    @PrimaryKey(autoGenerate = true)
    val cartItemId:Long=0L
)
