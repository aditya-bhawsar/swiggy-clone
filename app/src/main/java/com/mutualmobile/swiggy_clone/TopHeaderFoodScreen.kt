package com.mutualmobile.swiggy_clone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mutualmobile.swiggy_clone.R.drawable

@Composable
fun ToolBarContent() {
  Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
    Column(modifier = Modifier.weight(1f)) {
      Row() {
        Image(
          painter = painterResource(id = drawable.home_24), contentDescription = "home_icon"
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "Home", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.DarkGray
        )
      }
      Text(text = "Kukatpally, Hyderabad, People Pharmacy", fontSize = 14.sp, color = Color.Gray)
    }
    Image(painter = painterResource(id = drawable.user_48), contentDescription = "user")
  }
}

@Composable
fun SearchButton() {
  Box(
    modifier = Modifier
      .fillMaxWidth(), contentAlignment = Alignment.Center
  ) {
    Image(
      modifier = Modifier
        .height(50.dp)
        .fillMaxWidth(0.9f), painter = getBackgroundImage(drawableId = drawable.rectangle),
      contentDescription = "Background"
    )
    Row(
      modifier = Modifier
        .height(50.dp)
        .fillMaxWidth(0.9f), verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        modifier = Modifier
          .weight(1f)
          .padding(start = 16.dp), text = "Search for restaurant, item or more",
        fontSize = 16.sp, color = Color.DarkGray
      )
      Image(
        modifier = Modifier.padding(end = 16.dp),
        painter = painterResource(id = drawable.search_24), contentDescription = "user"
      )
    }
  }
}