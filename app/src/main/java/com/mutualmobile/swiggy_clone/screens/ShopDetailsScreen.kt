package com.mutualmobile.swiggy_clone.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.common.composable.CommonCard
import com.mutualmobile.swiggy_clone.common.isScrolled
import com.mutualmobile.swiggy_clone.ui.theme.Grey
import kotlinx.coroutines.NonDisposableHandle.parent


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Preview(showBackground = true)
@Composable
fun ShopDetailsScreen() {
  val lazyListState = rememberLazyListState()
  val systemUiController = rememberSystemUiController()
  SideEffect {
    systemUiController.setStatusBarColor(color = Color.Transparent)
  }
  Box {
    Scaffold(
      content = {
        Box(Modifier.fillMaxSize()) {

          CommonScrollToRevealToolbar(lazyListState) {

          }
        }
      }
    )
  }

}

@Composable
fun ShopListItems() {
  CommonCard(
    cardContent =
    Image(
      painter = painterResource(R.drawable.header_image),
      contentDescription = "",
      modifier = Modifier.fillMaxWidth(),
      contentScale = ContentScale.Crop
    )
  )

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CommonScrollToRevealToolbar(lazyListState: LazyListState, backButtonCallBack: () -> Unit) {
  val numbers = remember {
    List(size = 250) { it }
  }
  if (lazyListState.isScrolled) {
    DetailsTopAppBar(backButtonCallBack)
  }

  screenContent(lazyListState, numbers)
  }

@Composable
@OptIn(ExperimentalFoundationApi::class)
private fun screenContent(
  lazyListState: LazyListState,
  numbers: List<Int>
) {
  Column {
    //CommonCard(cardContent = ShopDetailsScreenHeader())
    LazyColumn(
      modifier = Modifier.padding(16.dp),
      state = lazyListState
    ) {


      items(items = numbers,
        key = { it }
      ) {
        Text(text = it.toString())
      }
    }
  }
}

@Preview(showBackground = true)
@Preview(showSystemUi = true)
@Composable
fun ShopDetailsScreenHeader() {
  ConstraintLayout {
    val (backButton, logo, searchButton, shopDetailsCard) = createRefs()

    Button(
      onClick = { },
      modifier = Modifier.constrainAs(backButton) {
        top.linkTo(parent.top, margin = 16.dp)
        start.linkTo(parent.start, margin = 16.dp)
      }
    ) {
      Icon(
        painterResource(R.drawable.ic_back),
        stringResource(R.string.toolbar_menu_description)
      )
    }

    Icon(  painterResource(R.drawable.ic_back),
      stringResource(R.string.toolbar_menu_description)
      , Modifier.constrainAs(searchButton) {
      end.linkTo(parent.end, margin = 16.dp)
        top.linkTo(parent.top, margin = 16.dp)
    })
  }
}


@Composable
private fun DetailsTopAppBar(backButtonCallBack: () -> Unit) {
  TopAppBar(
    modifier = Modifier
      .fillMaxWidth()
      .background(Grey)
      .height(height = 100.dp),
    elevation = 20.dp,
    title = {
      Text(text = "My title ")
    },
    navigationIcon = {
      IconButton(onClick = {
        backButtonCallBack.invoke()
      }) {
        Icon(
          painterResource(R.drawable.ic_back),
          stringResource(R.string.toolbar_menu_description)
        )
      }
    },
    backgroundColor = Gray
  )
}


@Composable
private fun CardContent() {
  Text("This is a card view")
}
