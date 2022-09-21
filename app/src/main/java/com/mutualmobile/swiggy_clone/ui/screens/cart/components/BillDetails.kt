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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyOrangeText
import com.mutualmobile.swiggy_clone.ui.theme.SwiggySubHeaderTextColor

@Composable
fun BillDetails(
    itemTotal: Int,
    distanceFee: Int,
    tax: Int,
    deliveryTip: Int,
    total: Int,
    onAddTipClicked: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
        SubHeaderText(header = stringResource(id = R.string.bill_details))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White)
                .padding(horizontal = 16.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            BillItem(label = stringResource(id = R.string.item_total), value = itemTotal)
            Spacer(modifier = Modifier.height(12.dp))
            BillItem(
                label = stringResource(id = R.string.delivery_fee),
                value = distanceFee,
                textDecoration = TextDecoration.Underline
            )
            Text(
                text = stringResource(id = R.string.delivery_fee_desc),
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black.copy(alpha = 0.4f)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Divider()
            Spacer(modifier = Modifier.height(12.dp))
            if (deliveryTip == 0) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(id = R.string.delivery_tip),
                        style = MaterialTheme.typography.bodySmall,
                        color = SwiggySubHeaderTextColor,
                    )
                    Text(
                        text = stringResource(id = R.string.add_tip),
                        style = MaterialTheme.typography.bodySmall,
                        color = SwiggyOrangeText,
                        modifier = Modifier.clickable {
                            onAddTipClicked()
                        },
                        textDecoration = TextDecoration.Underline
                    )
                }
            } else {
                BillItem(label = stringResource(id = R.string.delivery_tip), value = deliveryTip)
            }
            Spacer(modifier = Modifier.height(12.dp))
            BillItem(
                label = stringResource(id = R.string.taxes_and_charges),
                value = tax,
                textDecoration = TextDecoration.Underline
            )
            Spacer(modifier = Modifier.height(12.dp))
            Divider()
            Spacer(modifier = Modifier.height(12.dp))
            BillItem(
                label = stringResource(id = R.string.to_pay),
                value = total,
                labelColor = Color.Black
            )
        }
    }
}

@Composable
fun BillItem(
    label: String,
    value: Int,
    textDecoration: TextDecoration = TextDecoration.None,
    labelColor: Color = SwiggySubHeaderTextColor
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = labelColor,
            textDecoration = textDecoration
        )
        Text(text = "₹$value", style = MaterialTheme.typography.bodySmall, color = Color.Black)
    }
}

@Composable
fun Divider() {
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    androidx.compose.foundation.Canvas(
        Modifier
            .fillMaxWidth()
            .height(1.dp)) {
        drawLine(
            color = Color.Black,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = pathEffect
        )
    }
}