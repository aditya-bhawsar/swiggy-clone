package com.mutualmobile.swiggy_clone.ui.screens.coupon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.ui.screens.cart.components.Divider

@Composable
fun CouponList() {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "More offers",
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(top = 12.dp, bottom = 8.dp)
                .padding(horizontal = 12.dp)
        )
        CouponListItem(title = "Get 50% cashback", offer = "50% cashback", enabled = true)
        CouponListItem(title = "Get 30% cashback", offer = "30% cashback", enabled = true)
        CouponListItem(title = "Get 50% flat off", offer = "50% flat off", enabled = false)
        CouponListItem(title = "Get 40% cashback", offer = "40% flat off", enabled = false)
        CouponListItem(title = "Get 6% cashback", offer = "6% cashback", enabled = false)
        CouponListItem(title = "Get 2% cashback", offer = "2% cashback", enabled = false)
        CouponListItem(title = "Get 50% flat off", offer = "50% flat off", enabled = false)
        CouponListItem(title = "Get 50% cashback", offer = "50% cashback", enabled = false)

        Text(
            text = "Payment offers",
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(top = 12.dp, bottom = 8.dp)
                .padding(horizontal = 12.dp)
        )

        PaymentOffersItem(title = "Get 4% cashback")
        PaymentOffersItem(title = "Get 10% cashback")
        PaymentOffersItem(title = "Get 6% cashback")
        PaymentOffersItem(title = "Get 2% cashback")
        Spacer(modifier = Modifier.height(12.dp))
    }

}

@Composable
fun CouponListItem(title: String, offer: String, enabled: Boolean) {

    var showTerms by remember { mutableStateOf(false) }

    Card(modifier = Modifier
        .fillMaxSize()
        .padding(12.dp), colors = CardDefaults.cardColors(containerColor = Color.LightGray), elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = Color.White)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "  $offer  ".uppercase(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = Color.White,
                    modifier = Modifier
                        .background(if (enabled) Color(0xFFFFA500) else Color.DarkGray.copy(alpha = .5f))
                        .padding(12.dp)
                        .vertical()
                        .fillMaxHeight()
                        .rotate(-90f)
                )
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(modifier = Modifier.fillMaxWidth()) {

                        Column(modifier = Modifier.fillMaxWidth(.8f)) {
                            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painter = painterResource(id = R.drawable.veg), contentDescription = "",
                                    modifier = Modifier
                                        .size(52.dp)
                                        .padding(vertical = 8.dp),
                                    contentScale = ContentScale.FillWidth
                                )
                                Text(text = title,  modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp))
                            }
                            Text(text = "Add 280 more to avail this offer", style = MaterialTheme.typography.bodySmall,
                                color = Color.LightGray,
                                modifier = Modifier
                                    .padding(horizontal = 12.dp)
                                    .padding(bottom = 4.dp)
                                    .fillMaxWidth()
                            )
                            Text(text = "Get 20% more discount using indusland bank debit card ", style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                                modifier = Modifier
                                    .padding(horizontal = 12.dp)
                                    .padding(bottom = 8.dp)
                                    .fillMaxWidth()
                            )
                        }
                        Text(
                            modifier = Modifier
                                .padding(end = 12.dp)
                                .padding(vertical = 12.dp),
                            text = "APPLY",
                            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                            color = if (enabled) Color(0xFFFFA500) else Color.LightGray
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Flat 75 discount on the code above 230", style = MaterialTheme.typography.bodySmall,
                        color = Color.LightGray,
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .padding(bottom = 8.dp)
                            .fillMaxWidth()
                    )
                    if (!showTerms) {
                        Text(text = "+ MORE", style = MaterialTheme.typography.bodyMedium, color = Color.DarkGray,
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .padding(bottom = 12.dp)
                                .fillMaxWidth()
                                .clickable { showTerms = !showTerms }
                        )
                    }
                }
            }
        }
        if(showTerms) {
            Text(
                text = "Terms and Conditions Apply",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
            )
            Text(
                text = "• Offer is only on selected restaurants \n" +
                        "• Can be applied only once in 2 hours on this restaurant and any other subsidaries\n" +
                        "• Other T&C may apply\n" +
                        "• Offer valid only for 2 months",
                style = MaterialTheme.typography.bodySmall.copy(color = Color.DarkGray),
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
            )
        }

    }
}
fun Modifier.vertical() = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    layout(placeable.height, placeable.width) {
        placeable.place(
            x = -(placeable.width / 2 - placeable.height / 2),
            y = -(placeable.height / 2 - placeable.width / 2)
        )
    }
}