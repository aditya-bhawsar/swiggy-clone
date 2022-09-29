
package com.mutualmobile.swiggy_clone

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mutualmobile.swiggy_clone.common.composable.rememberScreenState
import com.mutualmobile.swiggy_clone.common.sealed.ScreenType
import com.mutualmobile.swiggy_clone.screens.ShopDetailsScreen
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyCloneTheme


class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      setFullScreen()
      SwiggyCloneTheme {
        ShopDetails()
      }
    }
  }

  private fun setFullScreen() {
    hideSystemUI()

  }

  private fun hideSystemUI() {
    window.addFlags(
      WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
    )
  }

  @Composable
  fun ShopDetails() {
    val uiState = rememberScreenState()
    when {
      uiState.widthState is ScreenType.Small -> {
        ShopDetailsScreen()
      }
      uiState.heightState is ScreenType.Medium -> {
        ShopDetailsScreen()
      }
      else -> {
        ShopDetailsScreen()
      }
    }
  }
}

@Preview(showBackground = true)
@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
  SwiggyCloneTheme {
    ShopDetailsScreen()
  }
}