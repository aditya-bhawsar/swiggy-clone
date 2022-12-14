package com.mutualmobile.swiggy_clone.ui.screens.cart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.common.composable.SpacerComponent
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyOrangeText
import com.mutualmobile.swiggy_clone.ui.theme.SwiggySubHeaderTextColor

@Composable
fun DeliveryInstructions() {
    val instructions = listOf(
        InstructionItem(image = R.drawable.ic_bell, label = R.string.avoid_bell),
        InstructionItem(image = R.drawable.ic_door, label = R.string.leave_door),
        InstructionItem(image = R.drawable.ic_mic, label = R.string.directions),
        InstructionItem(image = R.drawable.ic_phone, label = R.string.avoid_calling),
        InstructionItem(image = R.drawable.ic_security, label = R.string.leave_with_security),
    )

    Column() {
        SubHeaderText(header = stringResource(id = R.string.delivery_instructions))
        LazyRow {
            items(instructions) { item ->
                Row {
                    DeliveryInstructionsItem(imageResourceId = item.image, label = item.label)
                    SpacerComponent(dimensionResourceId = R.dimen.width_large, isVertical = false)
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun DeliveryInstructionsItem(imageResourceId: Int, label: Int) {

    var selected by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .size(dimensionResource(id = R.dimen.delivery_instruction_item_width))
            .clickable {
                selected = !selected
            }
            .border(
                width = if (selected) 1.dp else 0.dp,
                color = if (selected) SwiggyOrangeText else Color.White,
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.rounded_corner_large))
            )
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.rounded_corner_large)))
            .background(Color.White)
            .padding(horizontal = dimensionResource(id = R.dimen.padding_large)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Icon(
            painter = painterResource(id = imageResourceId),
            contentDescription = "$label icon",
            modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size_double_extra_large)),
            tint = if (selected) SwiggyOrangeText else SwiggySubHeaderTextColor
        )
        SpacerComponent(dimensionResourceId = R.dimen.width_large, isVertical = false)
        Text(
            text = stringResource(id = label),
            style = MaterialTheme.typography.bodySmall,
            color = SwiggySubHeaderTextColor
        )
    }
}

data class InstructionItem(
    val image: Int,
    val label: Int,
)