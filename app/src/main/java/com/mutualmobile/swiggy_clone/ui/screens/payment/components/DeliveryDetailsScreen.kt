package com.mutualmobile.swiggy_clone.payments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mutualmobile.swiggy_clone.R

@Composable
fun DeliveryDetails() {
  Column(
    modifier = Modifier
      .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
  ) {
    Card(shape = RoundedCornerShape(16.dp), elevation = 10.dp) {
      Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        getRightIcon(drawableId = R.drawable.chain, size = 50.dp)
        Column {
          Text(
            text = "Millet Kitchen Tiffins | Kukatpally", fontSize = 14.sp, color = Color.DarkGray
          )
          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = "Home | Kukatpally", fontSize = 14.sp, color = Color.DarkGray
          )
        }
      }
    }
  }
}