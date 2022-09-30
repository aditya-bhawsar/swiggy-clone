package com.mutualmobile.swiggy_clone.ui.screens.food

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.mutualmobile.swiggy_clone.common.composable.HeaderTextView
import com.mutualmobile.swiggy_clone.common.composable.getSpacer
import com.mutualmobile.swiggy_clone.ui.screens.food.components.ImageSlideShow
import com.mutualmobile.swiggy_clone.ui.screens.food.components.OfferAndGuilt
import com.mutualmobile.swiggy_clone.ui.screens.food.components.RestaurantsItem
import com.mutualmobile.swiggy_clone.ui.screens.food.components.SearchButton
import com.mutualmobile.swiggy_clone.ui.screens.food.components.ToolBarContent
import com.mutualmobile.swiggy_clone.ui.screens.food.components.TopRatedList
import com.mutualmobile.swiggy_clone.ui.screens.food.components.WhatOnYourMindList

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
        HeaderTextView(
          title = foodScreenViewModel.getRestaurantsList().size.toString() + " Restaurants to explore"
        )
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
        HeaderTextView(
          title = foodScreenViewModel.getRestaurantsList().size.toString() + " Restaurants to explore"
        )
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