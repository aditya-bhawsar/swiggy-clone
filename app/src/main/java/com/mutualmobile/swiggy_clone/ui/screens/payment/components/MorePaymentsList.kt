package com.mutualmobile.swiggy_clone.payments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.getDivider
import com.mutualmobile.swiggy_clone.models.OtherPayment

@Composable
fun MorePaymentList(otherPaymentsList: List<OtherPayment>) {
  Column(
    modifier = Modifier
      .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
  ) {
    Card(
      shape = RoundedCornerShape(16.dp), elevation = 10.dp
    ) {
      LazyColumn(state = rememberLazyListState()) {
        items(otherPaymentsList.size) { index ->
          MorePaymentsListItem(otherPaymentsList.get(index))
        }
      }
    }
  }
}

@Composable
fun MorePaymentItems(otherPaymentsList: List<OtherPayment>) {
  Column(
    modifier = Modifier
      .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
  ) {
    Card(
      shape = RoundedCornerShape(16.dp), elevation = 10.dp
    ) {
      Column() {
        for(item in otherPaymentsList){
          MorePaymentsListItem(item)
        }
      }
    }
  }
}

@Composable
fun MorePaymentsListItem(payment: OtherPayment) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
  ) {
    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
      Row(modifier = Modifier.weight(1f)) {
        getPaymentImage(drawableId = payment.drawableId)
        getPaymentsTexts(title = payment.title, description = payment.description)
      }
      getRightIcon(R.drawable.right_arrow_24, 15.dp)
    }
    getDivider()
  }
}

@Composable
fun getPaymentsTexts(
  title: String,
  description: String
) {
  Column(modifier = Modifier.padding(start = 16.dp)) {
    Text(text = title, fontSize = 14.sp, color = Color.DarkGray, fontWeight = FontWeight.Bold)
    Text(text = description, fontSize = 12.sp, color = Color.DarkGray)
  }
}