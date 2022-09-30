package com.mutualmobile.swiggy_clone.ui.screens.search.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.R

@Composable
fun PopularDishesSection() {

    Column(modifier = Modifier
        .padding(vertical = 12.dp)
        .fillMaxWidth()
        .background(color = Color.LightGray.copy(alpha = .5f))) {
        Column(modifier = Modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth()
            .background(color = Color.White)) {
            Text(
                text = "Popular Cuisines",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 8.dp)
                    .padding(top = 16.dp)
            )
            LazyRow(Modifier.padding(4.dp)){
                item {
                    CuisineItem("Dosa", R.drawable.dosa)
                    CuisineItem("Normal Khichdi", R.drawable.bg_1)
                    CuisineItem("Cake", R.drawable.bg_4)
                    CuisineItem("Uttapam", R.drawable.dosa)
                    CuisineItem("Tea", R.drawable.bg_3)
                    CuisineItem("Desserts", R.drawable.bg_5)
                    CuisineItem("Vada", R.drawable.dosa)
                    CuisineItem("Chinese", R.drawable.bg_2)
                }
            }

        }
    }

}

@Composable
fun CuisineItem(title: String, @DrawableRes res: Int) {
    Column(Modifier.padding(horizontal = 8.dp, vertical = 8.dp).width(64.dp)) {
        Image(painter = painterResource(id = res), contentDescription = "", Modifier.clip(CircleShape).size(64.dp).fillMaxWidth(), contentScale = ContentScale.FillBounds)
        Text(text = title, modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp), textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodySmall, color = Color.Gray)
    }
}


