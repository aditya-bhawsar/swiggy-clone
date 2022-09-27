package com.mutualmobile.swiggy_clone.viewmodels

import androidx.lifecycle.ViewModel
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.models.Restaurant
import com.mutualmobile.swiggy_clone.models.TopRatedNearYou
import com.mutualmobile.swiggy_clone.models.WhatsOnMind

class FoodScreenViewModel : ViewModel() {

  fun getTopRatedList(): MutableList<TopRatedNearYou> {
    val list = mutableListOf<TopRatedNearYou>()

    list.add(
      TopRatedNearYou(
        drawableId = R.drawable.bg_4, title = "Mehfil", description = "3.7 27 mins",
        isOfferAvailable = true, offerTitle = "10% OFF", offerDescription = "UPTO $15"
      )
    )
    list.add(
      TopRatedNearYou(
        drawableId = R.drawable.bg_1, title = "KS Bakers", description = "4.0 26 mins",
        isOfferAvailable = true, offerTitle = "30% OFF", offerDescription = "UPTO $65"
      )
    )

    list.add(
      TopRatedNearYou(
        drawableId = R.drawable.bg_2, title = "Abhi tiffins", description = "4.3 30 mins",
        isOfferAvailable = true, offerTitle = "20% OFF", offerDescription = "UPTO $50"
      )
    )

    list.add(
      TopRatedNearYou(
        drawableId = R.drawable.bg_3, title = "Chaithanya Foods", description = "4.2 38 mins",
        isOfferAvailable = true, offerTitle = "5% OFF", offerDescription = "UPTO $10"
      )
    )

    list.add(
      TopRatedNearYou(
        drawableId = R.drawable.bg_2, title = "Raja Rani Ruchulu", description = "4.5 45 mins",
        isOfferAvailable = true, offerTitle = "20% OFF", offerDescription = "UPTO $45"
      )
    )

    list.add(
      TopRatedNearYou(
        drawableId = R.drawable.bg_1, title = "Millet", description = "4.0 26 mins",
        isOfferAvailable = true, offerTitle = "20% OFF", offerDescription = "UPTO $25"
      )
    )

    list.add(
      TopRatedNearYou(
        drawableId = R.drawable.bg_3, title = "Krithunga", description = "4.3 30 mins",
        isOfferAvailable = true, offerTitle = "23% OFF", offerDescription = "UPTO $40"
      )
    )

    list.add(
      TopRatedNearYou(
        drawableId = R.drawable.bg_1, title = "KFC", description = "4.0 26 mins",
        isOfferAvailable = true, offerTitle = "50% OFF", offerDescription = "UPTO $55"
      )
    )

    list.add(
      TopRatedNearYou(
        drawableId = R.drawable.bg_2, title = "Vasista", description = "4.3 30 mins",
        isOfferAvailable = true, offerTitle = "20% OFF", offerDescription = "UPTO $50"
      )
    )
    list.add(
      TopRatedNearYou(
        drawableId = R.drawable.bg_5, title = "Pista house", description = "4.3 30 mins",
        isOfferAvailable = true, offerTitle = "20% OFF", offerDescription = "UPTO $50"
      )
    )
    return list
  }

  fun getQuickList(): MutableList<TopRatedNearYou> {
    return getTopRatedList()
  }

  fun getRestaurantsList(): MutableList<Restaurant> {
    val list = mutableListOf<Restaurant>()
    list.add(
      Restaurant(drawableId = R.drawable.rest_bg, isOfferAvailable = true,offerTitle = "20% OFF", offerDescription = "UPTO $50",
      restaurantName = "KS Bakers", restaurantRating = "4.3 30 mins", itemsDescriotion = "Pizza, Burger, pasta", area = "Kukatpally")
    )
    list.add(
      Restaurant(drawableId = R.drawable.rest_bg, isOfferAvailable = true,offerTitle = "20% OFF", offerDescription = "UPTO $50",
        restaurantName = "KS Bakers", restaurantRating = "4.3 30 mins", itemsDescriotion = "Pizza, Burger, pasta", area = "Kukatpally")
    )
    list.add(
      Restaurant(drawableId = R.drawable.rest_bg, isOfferAvailable = true,offerTitle = "20% OFF", offerDescription = "UPTO $50",
        restaurantName = "KS Bakers", restaurantRating = "4.3 30 mins", itemsDescriotion = "Pizza, Burger, pasta", area = "Kukatpally")
    )
    list.add(
      Restaurant(drawableId = R.drawable.rest_bg, isOfferAvailable = true,offerTitle = "20% OFF", offerDescription = "UPTO $50",
        restaurantName = "KS Bakers", restaurantRating = "4.3 30 mins", itemsDescriotion = "Pizza, Burger, pasta", area = "Kukatpally")
    )
    return list
  }

  fun getWhatsOnYourMindList(): MutableList<WhatsOnMind> {
    val list = mutableListOf<WhatsOnMind>()
    list.add(
      WhatsOnMind(
        drawableId1 = R.drawable.dosa, titleText1 = "Dosa", drawableId2 = R.drawable.paneer,
        titleText2 = "Biryani"
      )
    )
    list.add(
      WhatsOnMind(
        drawableId1 = R.drawable.bg_1, titleText1 = "Dosa", drawableId2 = R.drawable.bg_2,
        titleText2 = "Biryani"
      )
    )
    list.add(
      WhatsOnMind(
        drawableId1 = R.drawable.dosa, titleText1 = "Dosa", drawableId2 = R.drawable.paneer,
        titleText2 = "Biryani"
      )
    )

    list.add(
      WhatsOnMind(
        drawableId1 = R.drawable.bg_3, titleText1 = "Dosa", drawableId2 = R.drawable.bg_4,
        titleText2 = "Biryani"
      )
    )

    list.add(
      WhatsOnMind(
        drawableId1 = R.drawable.dosa, titleText1 = "Dosa", drawableId2 = R.drawable.paneer,
        titleText2 = "Biryani"
      )
    )

    list.add(
      WhatsOnMind(
        drawableId1 = R.drawable.bg_3, titleText1 = "Dosa", drawableId2 = R.drawable.bg_2,
        titleText2 = "Biryani"
      )
    )

    list.add(
      WhatsOnMind(
        drawableId1 = R.drawable.dosa, titleText1 = "Dosa", drawableId2 = R.drawable.paneer,
        titleText2 = "Biryani"
      )
    )

    list.add(
      WhatsOnMind(
        drawableId1 = R.drawable.bg_4, titleText1 = "Dosa", drawableId2 = R.drawable.bg_2,
        titleText2 = "Biryani"
      )
    )
    return list
  }
}