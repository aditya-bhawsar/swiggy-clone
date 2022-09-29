package com.mutualmobile.swiggy_clone.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.mutualmobile.swiggy_clone.ui.screens.cart.CartScreen
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyCloneTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      SwiggyCloneTheme {
        val widthSizeClass = calculateWindowSizeClass(this).widthSizeClass
        CartScreen(widthSizeClass)
      }
    }
  }
}