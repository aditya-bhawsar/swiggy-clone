package com.mutualmobile.swiggy_clone

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mutualmobile.swiggy_clone.models.Restaurant
import com.mutualmobile.swiggy_clone.models.TopRatedNearYou

@Composable
fun RestaurantsItem(restaurant: Restaurant) {
  Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(16.dp)) {
    TopRatedNearYouListItem(
      modifier = Modifier
        .height(180.dp)
        .width(140.dp), restaurant.toTopRatedNearYou()
    )
    RestaurantsItemTexts(restaurant)
  }
}

@Composable
fun RestaurantsItemTexts(restaurant: Restaurant) {
  Column(modifier = Modifier.padding(start = 16.dp)) {
    Text(
      text = restaurant.restaurantName, fontWeight = FontWeight.Bold, color = Color.DarkGray,
      fontSize = 16.sp
    )
    Spacer(modifier = Modifier.height(5.dp))
    Text(
      text = restaurant.restaurantRating, fontWeight = FontWeight.Bold, color = Color.DarkGray,
      fontSize = 16.sp
    )
    Spacer(modifier = Modifier.height(5.dp))
    /* if (restaurant.isOfferAvailable) {
       Text(
         text = "guiltfree options available", fontWeight = FontWeight.Bold,
         color = Color.DarkGray, fontSize = 16.sp
       )
       Spacer(modifier = Modifier.height(3.dp))
     }*/
    Text(text = restaurant.itemsDescriotion, color = Color.DarkGray, fontSize = 16.sp)
    Spacer(modifier = Modifier.height(5.dp))
    Text(text = restaurant.area, color = Color.DarkGray, fontSize = 16.sp)
    Spacer(modifier = Modifier.height(5.dp))
    OfferData()
  }
}

@Composable
fun OfferData() {
  Row() {
    Column(verticalArrangement = Arrangement.Center, modifier = Modifier.weight(1f)) {
      Text(
        text = "EXTRA 10% OFF", fontWeight = FontWeight.Bold, color = Color.Red, fontSize = 16.sp
      )
      Text(text = "AND FREE DELIVERY", color = Color.DarkGray, fontSize = 11.sp)
    }

    Column(verticalArrangement = Arrangement.Center, modifier = Modifier.padding(end = 4.dp)) {
      Text(text = "One", fontWeight = FontWeight.Bold, color = Color.Red, fontSize = 16.sp)
      Text(text = "BENEFITS", color = Color.DarkGray, fontSize = 11.sp)
    }
  }
}

fun Restaurant.toTopRatedNearYou() = TopRatedNearYou(
  drawableId = this.drawableId,
  title = "",
  description = "",
  isOfferAvailable = this.isOfferAvailable,
  offerTitle = this.offerTitle,
  offerDescription = this.offerDescription
)
