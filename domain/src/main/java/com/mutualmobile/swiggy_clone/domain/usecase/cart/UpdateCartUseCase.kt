package com.mutualmobile.swiggy_clone.domain.usecase.cart

import com.mutualmobile.swiggy_clone.domain.model.DMCartItem
import com.mutualmobile.swiggy_clone.domain.repo.CartRepository
import javax.inject.Inject

class UpdateCartUseCase @Inject constructor(private val cartRepository: CartRepository) {
    suspend operator fun invoke(dmCartItem: DMCartItem) = cartRepository.updateCartItem(dmCartItem)
}