package com.mutualmobile.swiggy_clone.ui.screens.payment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.R.drawable
import com.mutualmobile.swiggy_clone.common.composable.HeaderTextView
import com.mutualmobile.swiggy_clone.common.composable.getBackgroundImage
import com.mutualmobile.swiggy_clone.common.composable.getDivider
import com.mutualmobile.swiggy_clone.navigator.ComposeNavigator
import com.mutualmobile.swiggy_clone.payments.AddNewPayment
import com.mutualmobile.swiggy_clone.payments.DeliveryDetails
import com.mutualmobile.swiggy_clone.payments.MorePaymentItems
import com.mutualmobile.swiggy_clone.payments.MorePaymentList

@Composable
fun PaymentScreen(
  widthSizeClass: WindowWidthSizeClass,
  paymentsViewModel: PaymentsViewModel = hiltViewModel(),
  composeNavigator: ComposeNavigator,
  onBackPressed: () -> Unit,
) {

  Column(modifier = Modifier.background(color = colorResource(id = R.color.payment_backgound))) {
    PaymentToolBar(onBackPressed)
    if (widthSizeClass != WindowWidthSizeClass.Expanded) {
      Column(
        modifier = Modifier
          .verticalScroll(rememberScrollState())
          .weight(1f, false)
      ) {
        getTopItems()
        HeaderTextView(title = "More Payment Options")
        MorePaymentItems(otherPaymentsList = paymentsViewModel.getPaymentsList())
      }
    } else {
      Row() {
        Column(
          modifier = Modifier
            .verticalScroll(rememberScrollState())
            .weight(1f, false)
        ) {
          getTopItems()
        }
        Column(modifier = Modifier.weight(1f)) {
          HeaderTextView(title = "More Payment Options")
          MorePaymentList(otherPaymentsList = paymentsViewModel.getPaymentsList())
        }

      }
    }
  }
}

@Composable
fun getTopItems() {
  DeliveryDetails()
  HeaderTextView(title = "Preferred Payment")
  PreferredPayment()
  PaymentBanner()
  HeaderTextView(title = "Credit & Debit Cards")
  AddNewPayment()
}

@Composable
fun PreferredPayment() {
  Card(
    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
    shape = RoundedCornerShape(16.dp), elevation = 10.dp
  ) {
    Row(modifier = Modifier.padding(16.dp)) {
      getPaymentImage(drawableId = drawable.wallet_24)
      Column {
        Row(
          modifier = Modifier.padding(start = 16.dp, end = 8.dp, bottom = 16.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            modifier = Modifier.weight(1f), text = "satyavathi.android@okbankname",
            fontSize = 16.sp, maxLines = 1, overflow = TextOverflow.Ellipsis
          )
          Spacer(modifier = Modifier.width(4.dp))
          getRightIcon(drawable.check_circle_24, 24.dp)
        }
        getPreferredPaymentButton()
      }
    }
  }
}

@Composable
fun PaymentToolBar(onBackPressed: () -> Unit) {
  TopAppBar(modifier = Modifier.height(60.dp), backgroundColor = Color.White) {
    Column() {
      Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        getRightIcon(drawableId = drawable.back_arrow_24, size = 24.dp,onBackPressed)
        Spacer(modifier = Modifier.width(8.dp))
        Column() {
          Text(
            text = "Payment Options", fontWeight = FontWeight.Bold, fontSize = 16.sp,
            color = Color.DarkGray
          )
          Text(
            text = "1 item Total $100", fontSize = 12.sp, color = Color.Gray
          )
        }
      }
      getDivider()
    }
  }
}

@Composable
fun getPreferredPaymentButton() {
  Box(
    modifier = Modifier
      .height(40.dp)
      .padding(start = 32.dp, end = 32.dp), contentAlignment = Alignment.Center
  ) {
    Image(
      painter = getBackgroundImage(drawable.rectangle_payment),
      contentDescription = "bg",
    )
    Text(
      modifier = Modifier.padding(2.dp), text = "PAY VIA GOOGLEPAY", color = Color.White,
      fontWeight = FontWeight.Bold, fontSize = 10.sp
    )
  }
}

@Composable
fun getPaymentImage(
  drawableId: Int,
  modifier: Modifier = Modifier.size(40.dp),
  imageSize: Dp = 25.dp
) {
  Box(modifier = modifier, contentAlignment = Alignment.Center) {
    Image(
      painter = getBackgroundImage(drawable.rectangle_outline),
      contentDescription = "bg",
    )

    Image(
      modifier = Modifier
        .size(imageSize),
      painter = getBackgroundImage(drawableId),
      contentDescription = "bg",
    )
  }
}

@Composable
fun getRightIcon(
  drawableId: Int,
  size: Dp,
  onBackPressed: () -> Unit = {}
) {
  Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable { onBackPressed.invoke() }) {
    Image(
      modifier = Modifier
        .size(size),
      painter = getBackgroundImage(drawableId),
      contentDescription = "bg",
    )
  }
}

@Composable
fun PaymentBanner() {
  Column(
    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Card(
      modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(start = 16.dp, end = 16.dp), shape = RoundedCornerShape(16.dp), elevation = 10.dp
    ) {
      Image(
        painter = getBackgroundImage(drawableId = R.drawable.payment_banner),
        contentDescription = "", contentScale = ContentScale.FillBounds
      )
    }
  }
}

