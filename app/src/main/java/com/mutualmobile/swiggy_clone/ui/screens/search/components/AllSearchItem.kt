package com.mutualmobile.swiggy_clone.ui.screens.search.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.R

@Composable
fun AllSearchItem(title: String, type: String) {
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = R.drawable.non_veg), contentDescription = "", modifier = Modifier.size(52.dp))
        Column(Modifier.padding(8.dp)) {
            Text(text = title, style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Normal), color = Color.LightGray)
            Text(text = type, style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Normal), color = Color.LightGray)
        }
    }
}
