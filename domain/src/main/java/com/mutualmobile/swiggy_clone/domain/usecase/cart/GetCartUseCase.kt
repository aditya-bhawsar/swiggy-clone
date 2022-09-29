package com.mutualmobile.swiggy_clone.domain.usecase.cart

import com.mutualmobile.swiggy_clone.domain.model.DMCartItem
import com.mutualmobile.swiggy_clone.domain.repo.CartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCartUseCase @Inject constructor(private val cartRepository: CartRepository) {
    fun getCart(): Flow<List<DMCartItem>> = cartRepository.getCartItems()
    fun getCartTotal(): Flow<Int> = cartRepository.getCartTotal()
    fun getCartItemQuantity(): Flow<Int> = cartRepository.getCartQuantity()
}