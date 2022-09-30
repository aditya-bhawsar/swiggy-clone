package com.mutualmobile.swiggy_clone.payments

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.common.composable.getBackgroundImage
import com.mutualmobile.swiggy_clone.common.composable.getSpacer
import com.mutualmobile.swiggy_clone.ui.screens.payment.getPaymentImage

@Composable
fun AddNewPayment() {
  Card(
    shape = RoundedCornerShape(16.dp), elevation = 10.dp,
    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
  ) {
    Column(modifier = Modifier.padding(16.dp)) {
      AddPayment(title = "Add New Card", description = "Save and Pay via Cards.")
      getSpacer()
      val text =
        "Some of your saved cards might have been removed due to RBI guidelines. You can add your card again to continue using it."
      InfoText(text)
    }
  }
}

@Composable
fun AddPayment(
  title: String,
  description: String
) {
  Row() {
    getPaymentImage(
      modifier = Modifier
        .height(25.dp)
        .width(40.dp), drawableId = R.drawable.add_24,
      imageSize = 20.dp
    )
    Spacer(modifier = Modifier.width(12.dp))
    Column() {
      Text(
        text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp,
        color = colorResource(R.color.add_payment_color)
      )
      Text(
        text = description, fontSize = 12.sp, color = Color.Gray
      )
    }
  }
}

@Composable
fun InfoText(text: String) {
  Box(modifier = Modifier.height(80.dp)) {
    Image(
      painter = getBackgroundImage(drawableId = R.drawable.rectangle_corner_outline),
      contentDescription = ""
    )
    Row(modifier = Modifier.padding(8.dp)) {
      Image(
        modifier = Modifier.size(16.dp),
        painter = getBackgroundImage(drawableId = R.drawable.info_24), contentDescription = ""
      )
      Spacer(modifier = Modifier.width(8.dp))
      Text(text = text, color = Color.Gray)
    }
  }
}