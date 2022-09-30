package com.mutualmobile.swiggy_clone.ui.screens.food.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mutualmobile.swiggy_clone.common.composable.getSpacer
import com.mutualmobile.swiggy_clone.models.WhatsOnMind

@Composable
fun WhatOnYourMindList(whatsOnYourMindList: MutableList<WhatsOnMind>) {
  Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
    LazyRow(state = rememberLazyListState()) {
      items(whatsOnYourMindList.size) { index ->
        WhatOnMindListItem(whatsOnYourMindList.get(index))
      }
    }
  }
}

@Composable
fun WhatOnMindListItem(item: WhatsOnMind) {
  Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
    Image(
      modifier = Modifier.size(80.dp).clip(CircleShape), painter = painterResource(item.drawableId1), contentScale = ContentScale.FillBounds,
      contentDescription = "food_item"
    )
    Text(
      modifier = Modifier.padding(top = 4.dp), text = item.titleText1, fontSize = 12.sp,
      color = Color.DarkGray
    )

    getSpacer()

    Image(
      modifier = Modifier.size(80.dp).clip(CircleShape), painter = painterResource(item.drawableId2), contentScale = ContentScale.FillBounds,
      contentDescription = "food_item"
    )
    Text(
      modifier = Modifier.padding(top = 4.dp), text = item.titleText2, fontSize = 12.sp,
      color = Color.DarkGray
    )
  }
}

