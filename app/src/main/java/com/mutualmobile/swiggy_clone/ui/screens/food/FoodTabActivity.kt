package com.mutualmobile.swiggy_clone.ui.screens.food

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyCloneTheme


class FoodTabActivity : ComponentActivity() {

  @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      SwiggyCloneTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.background(color = Color.White)) {
          val widthSizeClass = calculateWindowSizeClass(this).widthSizeClass
          Column {
            val foodScreenViewModel: FoodScreenViewModel by viewModels()
            FoodScreen(widthSizeClass,foodScreenViewModel)
          }
        }
      }
    }
  }
}