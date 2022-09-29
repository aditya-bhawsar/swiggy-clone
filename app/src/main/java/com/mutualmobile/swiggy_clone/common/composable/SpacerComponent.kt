package com.mutualmobile.swiggy_clone.common.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource

@Composable
fun SpacerComponent(isVertical: Boolean = true, dimensionResourceId: Int) {
    if(isVertical) {
        Spacer(modifier = Modifier.height(dimensionResource(id = dimensionResourceId)))
    } else {
        Spacer(modifier = Modifier.width(dimensionResource(id = dimensionResourceId)))
    }
}