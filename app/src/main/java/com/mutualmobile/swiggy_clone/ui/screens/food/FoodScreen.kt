package com.mutualmobile.swiggy_clone.ui.screens.food

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow
import com.mutualmobile.swiggy_clone.common.composable.HeaderTextView
import com.mutualmobile.swiggy_clone.common.composable.HeightSpacer
import com.mutualmobile.swiggy_clone.navigator.ComposeNavigator
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
  foodScreenViewModel: FoodScreenViewModel = hiltViewModel(),
  composeNavigator: ComposeNavigator
) {
  Column(modifier = Modifier.fillMaxWidth()) {
    TopAppBar(modifier = Modifier.height(80.dp), backgroundColor = Color.White) {
      ToolBarContent()
    }
    if (widthSizeClass == WindowWidthSizeClass.Expanded) {
      MultiScreen(foodScreenViewModel = foodScreenViewModel, composeNavigator = composeNavigator)
    } else {
      SingleScreen(foodScreenViewModel = foodScreenViewModel, composeNavigator = composeNavigator)
    }
  }
}

@Composable
fun SingleScreen(foodScreenViewModel: FoodScreenViewModel, composeNavigator: ComposeNavigator) {
  LazyColumn(state = rememberLazyListState()) {
    item {
      Column(modifier = Modifier.padding(16.dp)) {
        TopItems(foodScreenViewModel, composeNavigator)
        HeightSpacer()
        HeaderTextView(
          title = foodScreenViewModel.getRestaurantsList().size.toString() + " Restaurants to explore"
        )
      }
    }
    items(foodScreenViewModel.getRestaurantsList().size) { index ->
      Column(modifier = Modifier.padding(start = 16.dp)) {
        RestaurantsItem(foodScreenViewModel.getRestaurantsList()[index], composeNavigator)
      }
    }
  }
}

@Composable
fun MultiScreen(foodScreenViewModel: FoodScreenViewModel, composeNavigator: ComposeNavigator) {
  Column(modifier = Modifier.padding(16.dp)) {
    LazyColumn {
      item {
        TopItems(foodScreenViewModel, composeNavigator)
        HeaderTextView(
          title = foodScreenViewModel.getRestaurantsList().size.toString() + " Restaurants to explore"
        )
      }
      item {
        FlowRow() {
          GridContent(foodScreenViewModel = foodScreenViewModel, composeNavigator = composeNavigator)
        }
      }
    }
  }
}

@Composable
internal fun GridContent(
  foodScreenViewModel: FoodScreenViewModel,
  composeNavigator: ComposeNavigator
) {
  repeat(foodScreenViewModel.getRestaurantsList().size) { index ->
    Column(modifier = Modifier.padding(4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
      RestaurantsItem(foodScreenViewModel.getRestaurantsList()[index], composeNavigator = composeNavigator)
    }
  }
}

@Composable
fun TopItems(foodScreenViewModel: FoodScreenViewModel, composeNavigator: ComposeNavigator) {
  Spacer(modifier = Modifier.height(8.dp))
  SearchButton(composeNavigator = composeNavigator)
  HeightSpacer()
  OfferAndGuilt()
  HeightSpacer()

  HeaderTextView(title = "Top rated near you")
  TopRatedList(foodScreenViewModel.getTopRatedList())

  HeightSpacer()
  ImageSlideShow(foodScreenViewModel.getImagesList())

  HeightSpacer()
  HeaderTextView(title = "Get it quickly")
  TopRatedList(foodScreenViewModel.getQuickList())

  HeightSpacer()

  HeaderTextView(title = "What's on your mind?")
  WhatOnYourMindList(foodScreenViewModel.getWhatsOnYourMindList())
}