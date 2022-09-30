package com.mutualmobile.swiggy_clone.ui.shopDetails.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.common.composable.BackButton
import com.mutualmobile.swiggy_clone.ui.theme.GreyLight
import com.mutualmobile.swiggy_clone.ui.theme.Spacing.extraLargeSpacing
import com.mutualmobile.swiggy_clone.ui.theme.Spacing.largeSpacing
import com.mutualmobile.swiggy_clone.ui.theme.Spacing.mediumSpacing
import com.mutualmobile.swiggy_clone.ui.theme.Spacing.noSpacing


@Composable
fun TopBar(
) {
  Column(
    modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .clip(
            RoundedCornerShape(
                topStart = noSpacing,
                topEnd = noSpacing,
                bottomStart = extraLargeSpacing,
                bottomEnd = extraLargeSpacing
            )
        )
        .background(GreyLight),
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    TitleLayout()
    ShopDetailsCard()
  }
}

@Composable
fun SearchButton(modifier: Modifier, onClick: () -> Unit) {
  Button(
    onClick = { Log.d("Details", "Clicked search") },
    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
    modifier = modifier
  ) {
    Row(modifier = Modifier.background(Color.Transparent)) {
      Image(
        painter = painterResource(id = R.drawable.ic_baseline_search_24),
        contentDescription = "",
        modifier = Modifier
          .clickable {
            onClick()
          }
      )
      Text(text = "Search", color = Color.Gray)
    }

  }
}

@Composable
fun ShopDetailsCard() {
  Column(
    modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(extraLargeSpacing)
        .clip(RoundedCornerShape(15))
        .background(Color.White),
    horizontalAlignment = Alignment.Start,
  ) {
    DetailsCardContent()
  }
}

@Composable
fun DetailsCardContent() {

  Text(
    text = "KFC",
    style = MaterialTheme.typography.bodyLarge,
    color = Color.Black,
    modifier = Modifier.padding(start = largeSpacing, top = largeSpacing)
  )
  Row(modifier = Modifier.padding(start = largeSpacing, top = mediumSpacing),
      verticalAlignment = Alignment.CenterVertically) {
    Image(
      modifier = Modifier
          .width(extraLargeSpacing)
          .height(extraLargeSpacing),
      painter = painterResource(id = R.drawable.ic_start_circular),
      contentDescription = null
    )
    Spacer(modifier = Modifier.width(4.dp))
    Text(
      text = "4.4 (500+ ratings)",
      style = MaterialTheme.typography.bodyMedium,
      color = Color.Black
    )
  }

    Text(
        text =  "₹400 for two . Americana chilz ",
        style = MaterialTheme.typography.labelSmall,
        color = Color.Gray,
        modifier = Modifier.padding(start = largeSpacing, top = mediumSpacing)
    )

    ShopDeliveryDetails("Newtown","Outlet")
    ShopDeliveryDetails("Delivery to Home","41 mins")
    Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(top = largeSpacing, start = largeSpacing,end =largeSpacing))
    farAwayWarningMsg()
}


@Composable
fun farAwayWarningMsg(){
  Row(
    modifier = Modifier.padding(start = largeSpacing, top = largeSpacing, bottom = largeSpacing),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Image(
      modifier = Modifier
        .width(extraLargeSpacing)
        .height(extraLargeSpacing),
      painter = painterResource(id = R.drawable.ic_info),
      contentDescription = null
    )
    Spacer(modifier = Modifier.width(mediumSpacing))
    Text(
      text = "Far (4-10Km) ",
      style = MaterialTheme.typography.bodyMedium,
      color = Color.Black
    )

    Text(
      text = "| Additional delivery fee will apply",
      style = MaterialTheme.typography.labelSmall,
      color = Color.Gray
    )



  }
}

@Composable
private fun ShopDeliveryDetails(destination: String, type:String) {
    Row(
        modifier = Modifier.padding(start = largeSpacing, top = mediumSpacing),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = type,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )
        Spacer(modifier = Modifier.width(largeSpacing))
        Text(
            text = destination,
            style = MaterialTheme.typography.labelSmall,
            color = Color.Black
        )
        Spacer(modifier = Modifier.width(4.dp))
        Image(
            modifier = Modifier
                .width(extraLargeSpacing)
                .height(extraLargeSpacing),
            painter = painterResource(id = R.drawable.ic_drop_down),
            contentDescription = null
        )

    }
}


@Composable
fun TitleLayout() {
  ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
    val (back, logo, search) = createRefs()
    BackButton(
      modifier = Modifier.constrainAs(back)
      {
        top.linkTo(parent.top, margin = largeSpacing)
        start.linkTo(parent.start, margin = largeSpacing)
      }
    ) {
      Log.d("Details", "Clicked Back")
    }

    Image(
      modifier = Modifier
          .width(30.dp)
          .height(30.dp)
          .shadow(elevation = 10.dp, shape = RoundedCornerShape(10.dp))
          .constrainAs(logo) {
              top.linkTo(parent.top, margin = largeSpacing)
              start.linkTo(parent.start)
              end.linkTo(parent.end)
          },
      painter = painterResource(id = R.drawable.circular_kfc),
      contentDescription = null
    )

    SearchButton(
      modifier = Modifier.constrainAs(search)
      {
        top.linkTo(parent.top, margin = mediumSpacing)
        end.linkTo(parent.end)
      }
    ) {
      Log.d("Details", "Clicked Back")
    }

  }
}