package com.mutualmobile.swiggy_clone.common.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CommonCard(cardContent: Unit,
               modifier: Modifier = Modifier.padding(16.dp),
               backGroundColor: Color = Color.Gray) {
  Card(
    modifier =modifier,
    elevation = 10.dp,
    backgroundColor = backGroundColor
  ) {
    cardContent
  }
}