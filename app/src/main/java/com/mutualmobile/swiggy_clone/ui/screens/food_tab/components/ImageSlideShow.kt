package com.mutualmobile.swiggy_clone.ui.screens.food_tab.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.mutualmobile.swiggy_clone.R.drawable
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageSlideShow(imagesList: List<Int>) {
  val state = rememberPagerState()
  Column {
    getDivider()
    getSpacer()
    SliderView(state, imagesList)
    Spacer(modifier = Modifier.padding(4.dp))
    DotsIndicator(
      totalDots = imagesList.size,
      selectedIndex = state.currentPage
    )
    getSpacer()
    getDivider()
  }
  LaunchedEffect(key1 = state.currentPage) {
    delay(3000)
    var newPosition = state.currentPage + 1
    if (newPosition > imagesList.size - 1) newPosition = 0
    state.scrollToPage(newPosition)
  }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SliderView(
  state: PagerState,
  imagesList: List<Int>
) {
  HorizontalPager(
    state = state,
    count = imagesList.size,
    modifier = Modifier
      .fillMaxWidth()
      .height(250.dp)
  ) { page ->
    Box(contentAlignment = Alignment.Center) {
      ImageCard(drawableId = imagesList.get(state.currentPage))
    }
  }
}

@Composable
fun ImageCard(
  drawableId: Int
) {
  Card(
    modifier = Modifier
      .width(500.dp)
      .height(250.dp), shape = RoundedCornerShape(16.dp), elevation = 10.dp
  ) {
    Image(
      painter = painterResource(drawableId),
      contentDescription = "food_item",
      contentScale = ContentScale.FillBounds
    )
  }
}

@Composable
fun DotsIndicator(
  totalDots: Int,
  selectedIndex: Int
) {

  LazyRow(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight(), horizontalArrangement = Arrangement.Center
  ) {

    items(totalDots) { index ->
      if (index == selectedIndex) {
        Box(
          modifier = Modifier
            .width(30.dp)
            .height(18.dp), contentAlignment = Companion.Center
        ) {

          Image(
            painter = getBackgroundImage(drawable.rectangle_dark),
            contentDescription = "bg",
            contentScale = ContentScale.FillBounds,
          )
          Text(
            text = (index + 1).toString() + "/" + totalDots.toString(), fontSize = 8.sp,
            color = Color.White
          )
        }
      } else {
        Box(
          modifier = Modifier
            .height(18.dp), contentAlignment = Companion.Center
        ) {
          Image(
            modifier = Modifier
              .size(6.dp),
            painter = getBackgroundImage(drawable.rectangle_dark),
            contentDescription = "bg",
            contentScale = ContentScale.FillBounds
          )
        }
      }

      if (index != totalDots - 1) {
        Spacer(modifier = Modifier.padding(horizontal = 3.dp))
      }
    }
  }
}