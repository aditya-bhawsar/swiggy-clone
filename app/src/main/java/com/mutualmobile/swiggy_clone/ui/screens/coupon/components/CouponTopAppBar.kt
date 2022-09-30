package com.mutualmobile.swiggy_clone.ui.screens.coupon.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.common.composable.BackButton

@Composable
fun CouponTopAppBar(
    searchBar: @Composable () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(topStartPercent = 0, topEndPercent = 0, bottomEndPercent = 12, bottomStartPercent = 12),
        color = Color.White
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.app_bar_height)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp)){
                    BackButton {}
                }

                Column(modifier = Modifier.fillMaxHeight().padding(horizontal = 8.dp), verticalArrangement = Arrangement.Center) {
                    Text(text = "APPLY COUPON", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
                    Text(text = "Your Cart: $12.0", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                }
            }
            Box(modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)){
                searchBar()
            }
        }
    }
}