package com.mutualmobile.swiggy_clone.ui.screens.coupon

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.ui.screens.cart.components.Divider
import com.mutualmobile.swiggy_clone.ui.screens.coupon.components.CouponList
import com.mutualmobile.swiggy_clone.ui.screens.coupon.components.CouponListItem
import com.mutualmobile.swiggy_clone.ui.screens.coupon.components.CouponTopAppBar
import com.mutualmobile.swiggy_clone.ui.screens.search.components.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ApplyCouponScreen(
    widthSizeClass: WindowWidthSizeClass,
    viewModel: ApplyCouponViewModel = hiltViewModel()
) {
    var query by rememberSaveable { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)){
                CouponTopAppBar {
                    SearchBar(
                        query = query,
                        queryChangedCallback = { query = it },
                        placeholderText = "Enter Coupon Code",
                        leadingComposable = {
                            IconButton(onClick = {  }) {
                                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "")
                            }
                        },
                        trailingComposable = {
                            Text(
                                modifier = Modifier.padding(end = 12.dp),
                                text = "APPLY",
                                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                color = if(query.isNotEmpty()) Color(0xFFFFA500) else Color.LightGray
                            )
                        }
                    )
                }
            }

        },
        bottomBar = {}
    ) {
        Column(modifier = Modifier
            .padding(paddingValues = it)
            .background(Color.LightGray)
            .fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()){
                item {
                    CouponList()
                }
            }
        }
    }

}