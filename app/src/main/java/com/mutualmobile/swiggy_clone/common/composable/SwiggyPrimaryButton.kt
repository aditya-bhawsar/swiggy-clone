package com.mutualmobile.swiggy_clone.common.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyOrangePrimary
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyOrangeSecondary

@Composable
fun SwiggyPrimaryButton(text: String, onCLick: () -> Unit) {
    Text(
        text = text,
        modifier = Modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.rounded_corner_medium)))
            .background(SwiggyOrangePrimary)
            .padding(
                horizontal = dimensionResource(id = R.dimen.padding_large),
                vertical = dimensionResource(
                    id = R.dimen.padding_12
                )
            )
            .clickable {
                onCLick()
            },
        color = SwiggyOrangeSecondary
    )
}