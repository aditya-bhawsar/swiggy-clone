package com.mutualmobile.swiggy_clone.ui.screens.coupon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.ui.screens.cart.components.Divider

@Composable
fun PaymentOffersItem(title: String) {

    var showTerms by remember { mutableStateOf(false) }

    Card(modifier = Modifier
        .fillMaxSize()
        .padding(12.dp), colors = CardDefaults.cardColors(containerColor = Color.LightGray), elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = Color.White)) {
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
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Pay using Cashback mode of Airtel Axis service Credit card & get 4% cashback", style = MaterialTheme.typography.bodySmall,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
            if(!showTerms){
                Text(text = "+ MORE", style = MaterialTheme.typography.bodyMedium, color = Color.DarkGray,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .padding(bottom = 12.dp)
                        .fillMaxWidth().clickable { showTerms = !showTerms }
                )
            }

        }
        if (showTerms) {
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