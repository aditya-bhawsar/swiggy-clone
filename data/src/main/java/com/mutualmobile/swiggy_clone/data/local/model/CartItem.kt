package com.mutualmobile.swiggy_clone.data.local.model

import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity
data class CartItem(
    @PrimaryKey(autoGenerate = true)
    val cartItemId:Long=0L
)
