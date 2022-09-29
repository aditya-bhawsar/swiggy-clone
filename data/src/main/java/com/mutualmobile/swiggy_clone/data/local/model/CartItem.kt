package com.mutualmobile.swiggy_clone.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CartItem(
    val isVegetarian: Boolean,
    val quantity: Int = 1,
    val title:String,
    val price:Int,
    @PrimaryKey(autoGenerate = true)
    val cartItemId: Long = 0L,
)
