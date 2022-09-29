package com.mutualmobile.swiggy_clone.common.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import coil.compose.rememberAsyncImagePainter

@Composable
fun HeaderTextView(title: String) {
  Text(
    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp), text = title,
    fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.DarkGray
  )
}

@Composable
fun getSpacer() = Spacer(modifier = Modifier.height(16.dp))

@Composable
fun getDivider() = Divider(
  color = Color.LightGray, thickness = 1.dp, modifier = Modifier
  .height(1.dp)
  .fillMaxWidth()
)

@Composable
fun getBackgroundImage(drawableId: Int) =
  rememberAsyncImagePainter(ContextCompat.getDrawable(LocalContext.current, drawableId))