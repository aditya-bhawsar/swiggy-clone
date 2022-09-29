package com.mutualmobile.swiggy_clone.ui.screens.food_tab.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
import com.mutualmobile.swiggy_clone.ui.screens.food_tab.FoodScreenViewModel

@Composable
fun FoodScreen(
  widthSizeClass: WindowWidthSizeClass,
  foodScreenViewModel: FoodScreenViewModel
) {
  Column(modifier = Modifier.fillMaxWidth()) {
    TopAppBar(modifier = Modifier.height(80.dp), backgroundColor = Color.White) {
      ToolBarContent()
    }
    if (widthSizeClass == WindowWidthSizeClass.Expanded) {
      MultiScreen(foodScreenViewModel = foodScreenViewModel)
    } else {
      SingleScreen(foodScreenViewModel = foodScreenViewModel)
    }
  }
}

@Composable
fun SingleScreen(foodScreenViewModel: FoodScreenViewModel) {
  LazyColumn(state = rememberLazyListState()) {
    item {
      Column(modifier = Modifier.padding(16.dp)) {
        TopItems(foodScreenViewModel = foodScreenViewModel)
        getSpacer()
        HeaderTextView(title = foodScreenViewModel.getRestaurantsList().size.toString()+" Restaurants to explore")
      }
    }
    items(foodScreenViewModel.getRestaurantsList().size) { index ->
      Column(modifier = Modifier.padding(start = 16.dp)) {
        RestaurantsItem(foodScreenViewModel.getRestaurantsList().get(index))
      }
    }
  }
}

@Composable
fun MultiScreen(foodScreenViewModel: FoodScreenViewModel) {
  Column(modifier = Modifier.padding(16.dp)) {
    LazyColumn {
      item {
        TopItems(foodScreenViewModel)
        HeaderTextView(title = foodScreenViewModel.getRestaurantsList().size.toString()+" Restaurants to explore")
      }
      item {
        FlowRow() {
          GridContent(foodScreenViewModel = foodScreenViewModel)
        }
      }
    }
  }
}

@Composable
internal fun GridContent(foodScreenViewModel: FoodScreenViewModel) {
  repeat(foodScreenViewModel.getRestaurantsList().size) { index ->
    Column(modifier = Modifier.padding(4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
      RestaurantsItem(foodScreenViewModel.getRestaurantsList().get(index))
    }
  }
}

@Composable
fun TopItems(foodScreenViewModel: FoodScreenViewModel) {
  getSpacer()
  SearchButton()
  getSpacer()
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

