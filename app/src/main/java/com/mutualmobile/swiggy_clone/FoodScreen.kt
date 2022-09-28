package com.mutualmobile.swiggy_clone

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mutualmobile.swiggy_clone.viewmodels.FoodScreenViewModel

@Composable
fun FoodScreen(foodScreenViewModel: FoodScreenViewModel) {
  Column(modifier = Modifier.fillMaxWidth()) {
    LazyColumn(state = rememberLazyListState()) {
      item {
        Column(modifier = Modifier.padding(16.dp)) {

          OfferAndGuilt()
          getSpacer()

          HeaderTextView(title = "Top rated near you")
          TopRatedList(foodScreenViewModel.getTopRatedList())

          getSpacer()
          ImageSlideShow(foodScreenViewModel.getImagesList())

          getSpacer()
          HeaderTextView(title = "Get it quickly")
          TopRatedList(foodScreenViewModel.getQuickList())

          getSpacer()

          HeaderTextView(title = "What's on your mind?")
          WhatOnYourMindList(foodScreenViewModel.getWhatsOnYourMindList())

          getSpacer()

          HeaderTextView(title = "Restaurants to explore")
        }
      }
      items(foodScreenViewModel.getRestaurantsList().size) { index ->
        Column(modifier = Modifier.padding(8.dp)) {
          RestaurantsItem(foodScreenViewModel.getRestaurantsList().get(index))
        }
      }
    }
  }
}

@Composable
fun HeaderTextView(title: String) {
  Text(
    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp), text = title,
    fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.DarkGray
  )
}

@Composable
fun getSpacer() = Spacer(modifier = Modifier.height(16.dp))

@Composable
fun getDivider() = Divider(
  color = Color.LightGray, thickness = 1.dp, modifier = Modifier
  .height(1.dp)
  .fillMaxWidth()
)

