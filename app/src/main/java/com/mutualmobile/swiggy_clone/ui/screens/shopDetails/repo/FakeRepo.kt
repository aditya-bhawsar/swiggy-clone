package com.mutualmobile.swiggy_clone.ui.screens.shopDetails.repo

import com.mutualmobile.swiggy_clone.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


fun getFakeFoodItems(): Flow<List<FoodItemModel>> {
  val list = ArrayList<FoodItemModel>();
  list.addAll(getFakeFoodItemsRec())
  list.addAll(getFakeFoodItemsBest())
  return flow {
    emit(list)
  }
}

private fun getFakeFoodItemsRec(): List<FoodItemModel> {
  return MutableList(20) {
    FoodItemModel(
      isVegg = true,
      name = "Peri Peri",
      description = "Enjoy  2 Dips and a Pepsi PET",
      price = "628.57",
      currentQuantity = 0,
      image = R.drawable.horizontal_item,
      rating = 3.5,
      categoryId = 0,
      categoryName = "Recommended",
    )
  }

}

private fun getFakeFoodItemsBest(): List<FoodItemModel> {
  return MutableList(10) {
    FoodItemModel(
      isVegg = false,
      name = "5 Leg PC Meal",
      description = "Medium Fries, 2 Dips and a Pepsi PET",
      categoryId = 1,
      categoryName = "Best Selling",
      price = "228.57",
      currentQuantity = 0,
      image = R.drawable.horizontal_item,
      rating = 4.5
    )
  }
}