package com.mutualmobile.swiggy_clone.ui.screens.food_tab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mutualmobile.swiggy_clone.ui.screens.food_tab.components.FoodScreen
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyCloneTheme


class FoodTabActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      SwiggyCloneTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.background(color = Color.White)) {
          Column {
            val foodScreenViewModel: FoodScreenViewModel by viewModels()
            FoodScreen(foodScreenViewModel)
          }
        }
      }
    }
  }
}