package com.mutualmobile.swiggy_clone.ui.common_composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.R

@Composable
fun BackButton(onClick: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.ic_back_arrow),
        contentDescription = "",
        modifier = Modifier.size(24.dp)
            .clickable {
                onClick()
            }
    )
}