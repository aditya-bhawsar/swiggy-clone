package com.mutualmobile.swiggy_clone.common.data

import androidx.compose.ui.unit.Dp
import com.mutualmobile.swiggy_clone.common.sealed.ScreenType

data class ScreenState(
    val widthState: ScreenType,
    val heightState: ScreenType,
    val width: Dp,
    val height: Dp
)
