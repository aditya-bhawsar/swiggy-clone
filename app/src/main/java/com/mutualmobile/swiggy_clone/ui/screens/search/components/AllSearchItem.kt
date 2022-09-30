package com.mutualmobile.swiggy_clone.ui.screens.search.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AllSearchItem(title: String, type: String, @DrawableRes image: Int) {
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = image), contentDescription = "", contentScale = ContentScale.FillBounds , modifier = Modifier.size(52.dp).clip(CircleShape))
        Column(Modifier.padding(8.dp)) {
            Text(text = title, style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Normal), color = Color.Gray)
            Text(text = type, style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Normal), color = Color.Gray)
        }
    }
}
