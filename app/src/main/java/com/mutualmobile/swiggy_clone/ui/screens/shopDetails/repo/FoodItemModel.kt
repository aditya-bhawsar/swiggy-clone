package com.mutualmobile.swiggy_clone.ui.screens.shopDetails.repo

import com.mutualmobile.swiggy_clone.R

data class FoodItemModel(
  val isVegg: Boolean = true,
  val name: String,
  val categoryId : Int,
  val categoryName : String,
  val description:String,
  val price:String,
  var currentQuantity:Int = 1,
  val image: Int = R.drawable.horizontal_item,
  var rating: Double = 4.00
)
