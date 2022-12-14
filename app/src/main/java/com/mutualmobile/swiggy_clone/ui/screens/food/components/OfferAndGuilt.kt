package com.mutualmobile.swiggy_clone.ui.screens.food.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.R.drawable
import com.mutualmobile.swiggy_clone.common.composable.BackgroundImagePainter

@Composable
fun OfferAndGuilt() {
  Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      val modifier: Modifier = Modifier
        .height(50.dp)
        .weight(1f)
      OfferAndGuiltItem(modifier, title = "Offer zone")
      Spacer(modifier = Modifier.width(16.dp))
      OfferAndGuiltItem(modifier, title = "guiltfree")
    }
  }
}

@Composable
fun OfferAndGuiltItem(
  modifier: Modifier,
  title: String
) {
  Box(modifier = modifier) {
    Row(modifier = modifier
      .background(color = colorResource(id = R.color.light_grey), shape = RoundedCornerShape(16.dp)).padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
      Text(
        modifier = Modifier.weight(1f), text = title, fontSize = 13.sp,
        fontWeight = FontWeight.Bold, color = Color.DarkGray
      )
      Image(painter = painterResource(drawable.burger), contentDescription = "image")
    }
  }
}