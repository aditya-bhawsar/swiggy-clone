package com.mutualmobile.swiggy_clone.ui.screens.food.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.mutualmobile.swiggy_clone.R.color
import com.mutualmobile.swiggy_clone.R.drawable
import com.mutualmobile.swiggy_clone.navigator.ComposeNavigator
import com.mutualmobile.swiggy_clone.navigator.SwiggyScreen

@Composable
fun ToolBarContent() {
  Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
    Column(modifier = Modifier.weight(1f)) {
      Row() {
        Image(
          painter = painterResource(id = drawable.home_24), contentDescription = "home_icon"
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "Home", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.DarkGray
        )
      }
      Text(text = "Kukatpally, Hyderabad, People Pharmacy", fontSize = 13.sp, color = Color.Gray)
    }
    Image(painter = painterResource(id = drawable.user_48), contentDescription = "user")
  }
}

@Composable
fun SearchButton(composeNavigator: ComposeNavigator) {

  Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
    Row(
      modifier = Modifier
        .height(50.dp)
        .background(
          shape = RoundedCornerShape(16.dp), color = colorResource(
          id = color.light_grey
        )).clickable { composeNavigator.navigate(SwiggyScreen.Search.name) }
        .padding(), verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        modifier = Modifier
          .weight(1f)
          .padding(start = 16.dp), text = "Search for restaurant, item or more",
        fontSize = 13.sp, color = Color.Gray
      )
      Image(
        modifier = Modifier.padding(end = 8.dp),
        painter = painterResource(id = drawable.search_24), contentDescription = "user"
      )
    }
  }
}