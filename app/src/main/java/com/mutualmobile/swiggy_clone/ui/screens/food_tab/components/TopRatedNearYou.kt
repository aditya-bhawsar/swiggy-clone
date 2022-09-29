package com.mutualmobile.swiggy_clone.ui.screens.food_tab.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import coil.compose.rememberAsyncImagePainter
import com.mutualmobile.swiggy_clone.R.color
import com.mutualmobile.swiggy_clone.R.drawable
import com.mutualmobile.swiggy_clone.models.TopRatedNearYou

@Composable
fun TopRatedNearYouListItem(
  modifier: Modifier = Modifier
    .width(140.dp)
    .height(140.dp),
  item: TopRatedNearYou
) {
  Box(
    modifier = modifier
  ) {
    Image(
      modifier = modifier,
      painter = painterResource(item.drawableId),
      contentDescription = "Background",
      contentScale = ContentScale.FillBounds
    )
    Column {
      Spacer(modifier = Modifier.height(16.dp))
      Row(verticalAlignment = Alignment.CenterVertically) {

        Column(modifier = Modifier.weight(1f)) {
          OneOfferItem("Free delivery")
        }
        Column(modifier = Modifier.padding(end = 4.dp), horizontalAlignment = Alignment.End) {
          FavouriteSymbol()
        }
      }
      if (item.isOfferAvailable) {
        Row(
          modifier = Modifier
            .weight(1f)
            .padding(8.dp), verticalAlignment = Alignment.Bottom
        ) {
          DiscountInfo(item)
        }
      }
    }
  }
}

@Composable
fun TopRateListItem(item: TopRatedNearYou) {
  Column(modifier = Modifier.padding(4.dp)) {
    TopRatedNearYouListItem(item = item)
    HotelInfo(item)
  }
}

@Composable
fun HotelInfo(item: TopRatedNearYou) {
  Column(modifier = Modifier.padding(8.dp)) {
    Text(text = item.title, color = Color.DarkGray, fontWeight = FontWeight.Bold, fontSize = 14.sp)
    Text(
      text = item.description, color = Color.DarkGray, fontWeight = FontWeight.Bold,
      fontSize = 12.sp
    )
  }
}

@Composable
fun OneOfferItem(
  text: String
) {
  Row(
    modifier = Modifier
      .background(color = Color(color.teal_700))
      .padding(4.dp), verticalAlignment = Alignment.CenterVertically
  ) {
    Image(painter = painterResource(drawable.donut), contentDescription = "one_image")
    Spacer(
      modifier = Modifier
        .width(4.dp)
        .height(4.dp)
    )
    Text(color = Color.White, text = text, fontSize = 12.sp)
  }
}

@Composable
fun FavouriteSymbol() {
  Image(
    painter = painterResource(drawable.ic_baseline_favorite_border_24),
    contentDescription = "fav_icon"
  )
}

@Composable
fun DiscountInfo(item: TopRatedNearYou) {
  Column(modifier = Modifier.padding(6.dp)) {
    Text(
      text = item.offerTitle, fontWeight = FontWeight.Bold, fontSize = 15.sp,
      color = Companion.White
    )
    Text(text = item.offerDescription, fontSize = 10.sp, color = Companion.White)
  }
}

@Composable
fun ItemsList(list: MutableList<TopRatedNearYou>) {
  Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
    LazyRow(state = rememberLazyListState()) {
      items(list.size) { index ->
        TopRateListItem(list.get(index))
      }
    }
  }
}

@Composable
fun TopRatedList(list: MutableList<TopRatedNearYou>) {
  ItemsList(list = list)
}

@Composable
fun getBackgroundImage(drawableId: Int) =
  rememberAsyncImagePainter(ContextCompat.getDrawable(LocalContext.current, drawableId))


