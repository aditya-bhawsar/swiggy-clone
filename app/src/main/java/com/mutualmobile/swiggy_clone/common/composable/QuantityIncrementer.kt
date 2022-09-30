package com.mutualmobile.swiggy_clone.common.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyGreen

@Composable
fun QuantityIncrementer(value: Int, onIncrement: () -> Unit, onDecrement: () -> Unit) {
    Row(
        modifier = Modifier
            .height(dimensionResource(id = R.dimen.height_extra_large))
            .border(
                1.dp,
                Color.Black.copy(alpha = 0.3f),
                RoundedCornerShape(dimensionResource(id = R.dimen.rounded_corner_small))
            )
            .clip(RoundedCornerShape(4.dp)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SpacerComponent(isVertical = false, dimensionResourceId = R.dimen.vertical_space_medium)
        Icon(
            painter = painterResource(id = R.drawable.ic_horizontal_rule),
            contentDescription = "",
            tint = SwiggyGreen,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.icon_size_large))
                .clickable {
                    onDecrement()
                }
        )
        SpacerComponent(isVertical = false, dimensionResourceId = R.dimen.vertical_space_medium)
        Text(text = "$value", color = SwiggyGreen)
        SpacerComponent(isVertical = false, dimensionResourceId = R.dimen.vertical_space_medium)
        Icon(
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = "",
            tint = SwiggyGreen,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.icon_size_large))
                .clickable {
                    onIncrement()
                }
        )
        SpacerComponent(isVertical = false, dimensionResourceId = R.dimen.vertical_space_medium)
    }
}