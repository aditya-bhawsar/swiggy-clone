package com.mutualmobile.swiggy_clone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import coil.compose.rememberAsyncImagePainter
import com.mutualmobile.swiggy_clone.R.drawable

@Composable
fun OfferAndGuilt() {
  Row() {
    val modifier: Modifier = Modifier
      .height(60.dp)
      .weight(1f)
    OfferAndGuiltItem(modifier, title = "Offer zone")
    Spacer(modifier = Modifier.width(16.dp))
    OfferAndGuiltItem(modifier, title = "guiltfree")
  }
}

@Composable
fun OfferAndGuiltItem(
  modifier: Modifier,
  title: String
) {
  Box(modifier = modifier) {
    Image(
      modifier = modifier, painter = rememberAsyncImagePainter(
      ContextCompat.getDrawable(
        LocalContext.current, drawable.rounded_rectangle
      )
    ), contentDescription = "Background"
    )

    Row(modifier = modifier.padding(18.dp), verticalAlignment = Alignment.CenterVertically) {
      Text(
        modifier = Modifier.weight(1f), text = title, fontSize = 15.sp,
        fontWeight = FontWeight.Bold, color = Color.Black
      )
      Image(painter = painterResource(drawable.burger), contentDescription = "image")
    }
  }
}