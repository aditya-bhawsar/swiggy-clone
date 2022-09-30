package com.mutualmobile.swiggy_clone.ui.screens.search

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.common.composable.BackButton
import com.mutualmobile.swiggy_clone.common.composable.SpacerComponent
import com.mutualmobile.swiggy_clone.ui.screens.search.components.AllSearchItem
import com.mutualmobile.swiggy_clone.ui.screens.search.components.PopularDishesSection
import com.mutualmobile.swiggy_clone.ui.screens.search.components.SearchBar
import com.mutualmobile.swiggy_clone.ui.screens.search.components.TrendingSearchesSection

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchScreen(
    widthSizeClass: WindowWidthSizeClass,
    viewModel: SearchScreenViewModel = hiltViewModel(),
    forRestaurant: Boolean
) {
    var query by rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = {
            Column(modifier = Modifier.fillMaxWidth()) {
                if(forRestaurant) {
                    Text(
                        text = "Search in Dream Sandwich . 33 mins",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(6.dp),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                ) {
                    SearchBar(
                        query = query,
                        queryChangedCallback = { query = it },
                        placeholderText = if(!forRestaurant) "Search for restaurant, item or more" else "Enter Dish Name",
                        leadingComposable = {
                                IconButton(onClick = {  }) {
                                    Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "")
                                }
                            },
                        trailingComposable = {
                                if (query.isNotEmpty()){
                                    IconButton(onClick = { query = "" }) {
                                        Icon(imageVector = Icons.Filled.Clear, contentDescription = "")
                                    }
                                }
                            }
                    )
                }
            }
        }
    ) {
        if(query.isEmpty()) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(it)) {
                TrendingSearchesSection{result ->  query = result}
                PopularDishesSection()
            }
        } else {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .verticalScroll(rememberScrollState())
            ) {
               AllSearchItem(title = "Dosa", type = "Dish")
               AllSearchItem(title = "Masala Dosa", type = "Dish")
               AllSearchItem(title = "Sada Dosa", type = "Dish")
               AllSearchItem(title = "Mysore Masala Dosa", type = "Dish")
               AllSearchItem(title = "Rava Masala Dosa", type = "Dish")
               AllSearchItem(title = "Neer Dosa", type = "Dish")
               AllSearchItem(title = "Mysore Sada Dosa", type = "Dish")
               AllSearchItem(title = "Rava Sada Dosa", type = "Dish")
               AllSearchItem(title = "Butter Sada Dosa", type = "Dish")
               AllSearchItem(title = "Rava Dosa", type = "Dish")
               Row(modifier = Modifier.fillMaxWidth().padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                   Image(imageVector = Icons.Filled.Search, contentDescription = "", modifier = Modifier.size(48.dp).padding(12.dp))
                   Text(text = "See all results for $query", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Normal), color = Color.LightGray)
               }
            }
        }
    }


}