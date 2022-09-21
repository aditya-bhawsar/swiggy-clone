package com.mutualmobile.swiggy_clone.ui.common_composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyGreen

@Composable
fun QuantityIncrementer(value: Int, onIncrement: () -> Unit, onDecrement: () -> Unit) {
    Row(
        modifier = Modifier
            .height(24.dp)
            .border(
                1.dp, Color.Black.copy(alpha = 0.3f), RoundedCornerShape(4.dp)
            )
            .clip(RoundedCornerShape(4.dp))
            ,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_horizontal_rule_24),
            contentDescription = "",
            tint = SwiggyGreen,
            modifier = Modifier
                .size(16.dp)
                .clickable {
                    onDecrement()
                }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "$value", color = SwiggyGreen)
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_add_24),
            contentDescription = "",
            tint = SwiggyGreen,
            modifier = Modifier
                .size(16.dp)
                .clickable {
                    onIncrement()
                }
        )
        Spacer(modifier = Modifier.width(8.dp))
    }
}