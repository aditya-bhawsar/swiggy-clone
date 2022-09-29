package com.mutualmobile.swiggy_clone.ui.screens.cart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyGreen

@Composable
fun BottomBar(
    onProceedClick: () -> Unit,
    price: String,
    onViewDetailedClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(vertical = 12.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = "₹$price",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(id = R.string.view_detailed_bill),
                style = MaterialTheme.typography.displaySmall,
                color = SwiggyGreen,
                modifier = Modifier.clickable {  }
            )
        }
        Text(
            text = stringResource(id = R.string.proceed_to_pay),
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(SwiggyGreen)
                .clickable { }
                .padding(horizontal = 24.dp, vertical = 12.dp)

        )
    }
}