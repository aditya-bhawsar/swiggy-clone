package com.mutualmobile.swiggy_clone.models

data class Restaurant(val drawableId: Int,
  val isOfferAvailable: Boolean,
  val offerTitle: String,
  val offerDescription: String,
  val restaurantName :String,
  val restaurantRating :String,
  val itemsDescriotion :String,
  val area :String,
)