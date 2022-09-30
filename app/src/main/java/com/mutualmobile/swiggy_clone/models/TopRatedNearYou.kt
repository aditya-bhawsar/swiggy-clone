package com.mutualmobile.swiggy_clone.models

data class TopRatedNearYou(
  val drawableId: Int,
  val title: String,
  val description: String,
  val isOfferAvailable: Boolean,
  val offerTitle: String,
  val offerDescription: String,
)
