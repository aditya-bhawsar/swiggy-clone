package com.mutualmobile.swiggy_clone.common.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.ui.theme.Spacing

@Composable
fun RoundedButton(content: @Composable () -> Unit) {
  OutlinedButton(
    modifier = Modifier.wrapContentSize().padding(Spacing.mediumSpacing),
    onClick = { },
    border = BorderStroke(1.dp, Color.LightGray),
    shape = RoundedCornerShape(45),
    // or shape = CircleShape
    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
  ){
    content()
  }
}
