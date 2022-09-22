package com.mutualmobile.swiggy_clone.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CartItem(
    @PrimaryKey(autoGenerate = true)
    val cartItemId: Long = 0L
)
