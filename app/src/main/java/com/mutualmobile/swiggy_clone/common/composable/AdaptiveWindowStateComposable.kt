package com.mutualmobile.swiggy_clone.common.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.common.Constants.MaxSizeForMediumHeight
import com.mutualmobile.swiggy_clone.common.Constants.MaxSizeForMediumWidth
import com.mutualmobile.swiggy_clone.common.Constants.MaxSizeForSmallHeight
import com.mutualmobile.swiggy_clone.common.Constants.MaxSizeForSmallWidth
import com.mutualmobile.swiggy_clone.common.data.ScreenState
import com.mutualmobile.swiggy_clone.common.sealed.ScreenType

val maxSizeForWidth = Pair(MaxSizeForSmallWidth, MaxSizeForMediumWidth)
val maxSizeForHeight = Pair(MaxSizeForSmallHeight, MaxSizeForMediumHeight)

@Composable
fun rememberScreenState(): ScreenState {
    val localConfig = LocalConfiguration.current
    val screenWidth = localConfig.screenWidthDp
    val screenHeight = localConfig.screenHeightDp
    return ScreenState(
        widthState = getState(screenWidth, maxSizeForWidth),
        heightState = getState(screenHeight, maxSizeForHeight),
        screenWidth.dp,
        screenHeight.dp
    )
}

fun getState(screenWidth: Int, maxSize: Pair<Int, Int>): ScreenType {
    return when {
        screenWidth < maxSize.first -> {
            ScreenType.Small
        }
        screenWidth < maxSize.second -> {
            ScreenType.Medium
        }
        else -> ScreenType.Large
    }
}
