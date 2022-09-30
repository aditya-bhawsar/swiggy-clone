package com.mutualmobile.swiggy_clone.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.mutualmobile.swiggy_clone.ui.shopDetails.ShopDetailsScreen
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mutualmobile.swiggy_clone.navigator.ComposeNavigator
import com.mutualmobile.swiggy_clone.navigator.SwiggyRoute
import com.mutualmobile.swiggy_clone.ui.screens.orderRoute
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyCloneTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  @Inject
  lateinit var composeNavigator: ComposeNavigator

  @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      val navController = rememberNavController()

      LaunchedEffect(Unit) {
        composeNavigator.handleNavigationCommands(navController)
      }
      SwiggyCloneTheme {
        val widthSizeClass = calculateWindowSizeClass(this).widthSizeClass
        NavHost(
          navController = navController,
          startDestination = SwiggyRoute.Order.name,
        ) {
          orderRoute(composeNavigator, widthSizeClass)
        }
       // ShopDetailsScreen()
        //CartScreen(widthSizeClass)
      }
    }
  }
}