package com.mutualmobile.swiggy_clone.ui.screens.shopDetails

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.TopAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.common.composable.RoundedButton
import com.mutualmobile.swiggy_clone.common.isScrolled
import com.mutualmobile.swiggy_clone.navigator.ComposeNavigator
import com.mutualmobile.swiggy_clone.ui.screens.shopDetails.components.TopBar
import com.mutualmobile.swiggy_clone.ui.screens.shopDetails.repo.FoodItemModel
import com.mutualmobile.swiggy_clone.ui.theme.Spacing


@Preview(showSystemUi = true)
@Preview(showBackground = true)
@Composable
fun ShopDetailsScreen(
  viewModel: ShopDetailsVM = hiltViewModel(),
  composeNavigator: ComposeNavigator
) {
  val lazyListState = rememberLazyListState()
  val systemUiController = rememberSystemUiController()
  SideEffect {
    systemUiController.setStatusBarColor(color = Color.Transparent)
  }

  val shopItemsState by viewModel.shopItems.collectAsState()
  val items by shopItemsState.collectAsState(initial = emptyList())


  Surface(modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.background) {
    Column() {
      CommonScrollToRevealToolbar(lazyListState, items) {
      }
    }

  }

}


@Composable
fun CommonScrollToRevealToolbar(
  lazyListState: LazyListState,
  items: List<FoodItemModel>,
  backButtonCallBack: () -> Unit
) {
  if (lazyListState.isScrolled) {
    DetailsTopAppBar(backButtonCallBack)
  }
  screenContent(lazyListState, items)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun screenContent(
  lazyListState: LazyListState,
  shopItems: List<FoodItemModel>,
) {
  LazyColumn(
    modifier = Modifier,
    state = lazyListState
  ) {
    item {
      TopBar()
      MenuFilter()
    }

    stickyHeader {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .wrapContentHeight()
          .background(Color.White)
      ) {
        foodFilterOptions()
        Divider(
          modifier = Modifier
            .padding(
              top = Spacing.mediumSpacing,
              start = Spacing.noSpacing,
              end = Spacing.mediumSpacing
            ),
          color = LightGray,
          thickness = 1.dp
        )
      }

    }

    val groupedItems = shopItems.groupBy { foodItem ->
      foodItem.categoryName
    }

    groupedItems.forEach { (category, foodItems) ->
      item {
        populateHeader("$category (${foodItems.size})")
      }
      items(foodItems.size) { index ->
        FoodItemCard(shopItems[index])
      }
      item {
        Divider(
          modifier = Modifier.padding(top = Spacing.mediumSpacing),
          color = LightGray,
          thickness = 15.dp
        )
      }
    }

  }
}

@Composable
private fun populateHeader(header: String) {
  Text(
    text = header,
    style = MaterialTheme.typography.titleMedium,
    color = Color.Black,
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
      .padding(
        top = Spacing.extraLargeSpacing,
        bottom = Spacing.extraLargeSpacing,
        start = Spacing.mediumSpacing
      ),
    textAlign = TextAlign.Start
  )
}

@Composable
fun FoodItemCard(item: FoodItemModel) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
      .padding(
        horizontal = Spacing.mediumSpacing,
        vertical = Spacing.extraLargeSpacing
      ),
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    ItemDescription(item)
    Spacer(Modifier.weight(1f))
    ItemImage(item)
  }
  Divider(
    modifier = Modifier.padding(top = Spacing.mediumSpacing),
    color = LightGray,
    thickness = 1.dp
  )
}

@Composable
fun ItemImage(item: FoodItemModel) {
  Column {
    Image(
      modifier = Modifier
        .shadow(elevation = 10.dp, shape = RoundedCornerShape(5.dp)),
      painter = painterResource(id = item.image),
      contentDescription = null
    )
    AddButton(item)
  }

}

@Composable
fun AddButton(foodItemModel: FoodItemModel) {
  Button(
    onClick = { /*TODO*/ },
    modifier = Modifier.padding(start = Spacing.largeSpacing),
    elevation = ButtonDefaults.buttonElevation(defaultElevation = 36.dp),
    colors = ButtonDefaults.buttonColors(containerColor = White),
    shape = RoundedCornerShape(5.dp)
  ) {
    Text(text = "ADD",color = Color.Green)
  }


}



@Composable
private fun ItemDescription(item: FoodItemModel) {
  Column {
    Image(
      painter = painterResource(id = R.drawable.non_veg), contentDescription = "",
      modifier = Modifier.size(25.dp)
    )
    Spacer(modifier = Modifier.width(Spacing.mediumSpacing))
    Text(
      text = item.name,
      style = MaterialTheme.typography.bodyMedium,
      color = Color.Black
    )
    Spacer(modifier = Modifier.width(Spacing.mediumSpacing))

    Text(
      text = "₹${item.price}",
      style = MaterialTheme.typography.labelSmall,
      color = Color.Gray,
      modifier = Modifier.padding( top = Spacing.mediumSpacing)
    )


    RatingBar(
      value = item.rating.toFloat(),
      config = RatingBarConfig()
        .size(14.dp)
        .style(RatingBarStyle.HighLighted),
      onValueChange = {},
      onRatingChanged = {}
    )

    Text(
      text = item.description,
      style = MaterialTheme.typography.labelSmall,
      color = Color.Gray,
      modifier = Modifier.padding( top = Spacing.mediumSpacing)
    )
  }
}

@Composable
fun MenuFilter() {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
  ) {
    Text(
      text = "<   MENU   >",
      style = MaterialTheme.typography.displaySmall,
      color = Color.Black,
      modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(Spacing.extraLargeSpacing),
      textAlign = TextAlign.Center
    )


  }
}

@Composable
private fun foodFilterOptions() {
  Row(modifier = Modifier.padding(start = Spacing.largeSpacing)) {
    RoundedButton {
      sortVegNonVeg()
    }
    RoundedButton {
      Text(
        modifier = Modifier.wrapContentSize(),
        text = "Bestseller",
        style = MaterialTheme.typography.bodyMedium,
        color = Color.Gray
      )
    }
  }
}

@Composable
private fun sortVegNonVeg() {
  Row(modifier = Modifier.wrapContentSize()) {
    Image(
      painter = painterResource(id = R.drawable.veg), contentDescription = "",
      modifier = Modifier
        .size(25.dp)
        .padding(end = Spacing.small)
    )
    Image(
      painter = painterResource(id = R.drawable.nonveg), contentDescription = "",
      modifier = Modifier.size(25.dp)
    )
    Image(
      painter = painterResource(id = R.drawable.ic_arrow_down), contentDescription = "",
      modifier = Modifier.size(25.dp)
    )
  }
}


@Composable
private fun DetailsTopAppBar(backButtonCallBack: () -> Unit) {
  TopAppBar(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight(),
    elevation = 40.dp,
    title = {
      Text(
        text = "KFC . 40 mis",
        style = MaterialTheme.typography.bodyLarge,
        color = Color.Black
      )
    },
    navigationIcon = {
      IconButton(onClick = {
        backButtonCallBack.invoke()
      }) {
        Icon(
          painterResource(R.drawable.ic_back_details),
          stringResource(R.string.toolbar_menu_description)
        )
      }
    },
    backgroundColor = White
  )
}


@Composable
private fun CardContent() {
  Text("This is a card view")
}
