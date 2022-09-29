package com.mutualmobile.swiggy_clone.ui.screens.cart

import android.content.Context
import androidx.lifecycle.ViewModel
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.common.data.TipItem
import com.mutualmobile.swiggy_clone.domain.usecase.cart.DeleteCartUseCase
import com.mutualmobile.swiggy_clone.domain.usecase.cart.GetCartUseCase
import com.mutualmobile.swiggy_clone.domain.usecase.cart.InsertCartUseCase
import com.mutualmobile.swiggy_clone.domain.usecase.cart.UpdateCartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val insertCartUseCase: InsertCartUseCase,
    private val getCartUseCase: GetCartUseCase,
    private val updateCartUseCase: UpdateCartUseCase,
    private val deleteCartUseCase: DeleteCartUseCase,
    @ApplicationContext private val context: Context
) : ViewModel() {
    private val _tipInstructions = MutableStateFlow<Flow<List<TipItem>>>(emptyFlow())
    val tipInstructions = _tipInstructions.asStateFlow()

    init {
        _tipInstructions.value = fetchTipInstructions()
    }

    private fun fetchTipInstructions(): Flow<List<TipItem>> {
        val tips:List<TipItem> = listOf(
            TipItem(label = context.getString(R.string.delivery_tip_10), value = 10),
            TipItem(label = context.getString(R.string.delivery_tip_20), value = 20),
            TipItem(label = context.getString(R.string.delivery_tip_30), value = 30),
        )

        return flow {
            emit(tips)
        }
    }
}