package com.mutualmobile.swiggy_clone.domain.repo

import com.mutualmobile.swiggy_clone.domain.model.DMCartItem
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    suspend fun insertCartItem(dmCartItem: DMCartItem)
    suspend fun updateCartItem(dmCartItem: DMCartItem)
    suspend fun deleteCartItem(dmCartItem: DMCartItem)
    fun getCartItems() : Flow<List<DMCartItem>>
    fun getCartTotal() : Flow<Int>
    fun getCartQuantity() : Flow<Int>
}