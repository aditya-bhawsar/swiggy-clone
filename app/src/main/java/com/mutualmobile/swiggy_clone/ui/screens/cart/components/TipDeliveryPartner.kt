package com.mutualmobile.swiggy_clone.ui.screens.cart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyOrangeText

@Composable
fun TipDeliveryPartner(onTipItemClicked: (tip: Int) -> Unit,tipValue:Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        SubHeaderText(header = stringResource(id = R.string.tip_delivery))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White)
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.delivery_desc),
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(16.dp))
            TipsRow(onTipItemClicked,"₹$tipValue")
        }
    }
}

@Composable
fun TipsRow(onTipItemClicked: (tip: Int) -> Unit,selected: String) {
    val tips = listOf(
        TipItem(label = stringResource(id = R.string.delivery_tip_10), value = 10),
        TipItem(label = stringResource(id = R.string.delivery_tip_20), value = 20),
        TipItem(label = stringResource(id = R.string.delivery_tip_30), value = 30),
    )


    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        tips.forEach { item ->
            Surface(
                shadowElevation = 8.dp,
                modifier = Modifier
                    .border(
                        1.dp,
                        color = if (selected == item.label) SwiggyOrangeText else Color.Black.copy(
                            alpha = 0.2f
                        ),
                        RoundedCornerShape(8.dp)
                    )
                    .clip(RoundedCornerShape(8.dp)),
            ) {
                Text(
                    text = item.label,
                    style = MaterialTheme.typography.bodyMedium.copy(textAlign = TextAlign.Center),
                    modifier = Modifier
                        .width(70.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            Color.White
                        )
                        .clickable {
                            if (selected == item.label) {
                                onTipItemClicked(0)
                            } else {
                                onTipItemClicked(item.value)
                            }
                        }
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

data class TipItem(
    val label: String,
    val value: Int
)