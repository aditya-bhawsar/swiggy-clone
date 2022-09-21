package com.mutualmobile.swiggy_clone.ui.screens.cart

import androidx.lifecycle.ViewModel
import com.mutualmobile.swiggy_clone.domain.usecase.cart.DeleteCartUseCase
import com.mutualmobile.swiggy_clone.domain.usecase.cart.GetCartUseCase
import com.mutualmobile.swiggy_clone.domain.usecase.cart.InsertCartUseCase
import com.mutualmobile.swiggy_clone.domain.usecase.cart.UpdateCartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val insertCartUseCase: InsertCartUseCase,
    private val getCartUseCase: GetCartUseCase,
    private val updateCartUseCase: UpdateCartUseCase,
    private val deleteCartUseCase: DeleteCartUseCase,
) : ViewModel() {
}