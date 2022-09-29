package com.mutualmobile.swiggy_clone.data.local.repo

import com.mutualmobile.swiggy_clone.data.local.dao.CartDao
import com.mutualmobile.swiggy_clone.data.local.mappers.MapperFunctions.toCartItem
import com.mutualmobile.swiggy_clone.data.local.mappers.MapperFunctions.toDmCartItem
import com.mutualmobile.swiggy_clone.domain.model.DMCartItem
import com.mutualmobile.swiggy_clone.domain.repo.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val cartDao: CartDao
) : CartRepository {
    override suspend fun insertCartItem(dmCartItem: DMCartItem) {
        cartDao.insertItem(dmCartItem.toCartItem())
    }

    override suspend fun updateCartItem(dmCartItem: DMCartItem) {
        cartDao.insertItem(dmCartItem.toCartItem())
    }

    override suspend fun deleteCartItem(dmCartItem: DMCartItem) {
        cartDao.deleteItem(dmCartItem.toCartItem())
    }

    override fun getCartItems(): Flow<List<DMCartItem>> {
        return cartDao.getCartItems().mapLatest {
            it.map { cartItem ->
                cartItem.toDmCartItem()
            }
        }
    }

    override fun getCartTotal(): Flow<Int> {
        return cartDao.getCartTotal()
    }

    override fun getCartQuantity(): Flow<Int> {
        return cartDao.getCartQuantity()
    }
}