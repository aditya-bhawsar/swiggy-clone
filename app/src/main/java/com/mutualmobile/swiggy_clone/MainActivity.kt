package com.mutualmobile.swiggy_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyCloneTheme
import com.mutualmobile.swiggy_clone.viewmodels.FoodScreenViewModel

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      SwiggyCloneTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.background(color = Color.Cyan)) {

        Column() {
         //TODO TopAppBar(title = { Text(text = "Adopt Me") }, backgroundColor = Color.Red)
          val foodScreenViewModel: FoodScreenViewModel by viewModels()
          FoodScreen(foodScreenViewModel)
        }
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String) {
  Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  SwiggyCloneTheme {
    Greeting("Android")
  }
}