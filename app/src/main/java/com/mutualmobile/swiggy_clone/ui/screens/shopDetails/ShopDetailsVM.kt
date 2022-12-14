package com.mutualmobile.swiggy_clone.ui.screens.shopDetails

import androidx.lifecycle.ViewModel
import com.mutualmobile.swiggy_clone.ui.screens.shopDetails.repo.FoodItemModel
import com.mutualmobile.swiggy_clone.ui.screens.shopDetails.repo.getFakeFoodItems
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ShopDetailsVM @Inject constructor():ViewModel() {
  private val _shopItems = MutableStateFlow<Flow<List<FoodItemModel>>>(emptyFlow())
  val shopItems = _shopItems.asStateFlow()
  init {
    _shopItems.value = getFakeFoodItems()
  }


}