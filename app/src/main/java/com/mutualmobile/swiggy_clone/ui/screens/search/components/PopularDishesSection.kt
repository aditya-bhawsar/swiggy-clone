package com.mutualmobile.swiggy_clone.ui.screens.search.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                    CuisineItem("Dosa")
                    CuisineItem("Normal Khichdi")
                    CuisineItem("Cake")
                    CuisineItem("Uttapam")
                    CuisineItem("Tea")
                    CuisineItem("Desserts")
                    CuisineItem("Vada")
                    CuisineItem("Chinese")
                }
            }

        }
    }

}

@Composable
fun CuisineItem(title: String) {
    Column(Modifier.padding(horizontal = 4.dp, vertical = 8.dp).width(72.dp)) {
        Image(painter = painterResource(id = R.drawable.non_veg), contentDescription = "")
        Text(text = title, modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp), textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodySmall, color = Color.Gray)
    }
}


