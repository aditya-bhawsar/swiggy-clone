package com.mutualmobile.swiggy_clone.common.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.mutualmobile.swiggy_clone.R

@Composable
fun BackButton(
  modifier: Modifier = Modifier
    .size(dimensionResource(id = R.dimen.icon_size_extra_large)), onClick: () -> Unit
) {
  Image(
    painter = painterResource(id = R.drawable.ic_back_details),
    contentDescription = "",
    modifier = modifier
      .clickable {
        onClick()
      }
  )
}