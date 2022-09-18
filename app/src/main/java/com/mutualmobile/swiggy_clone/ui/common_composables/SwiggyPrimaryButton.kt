package com.mutualmobile.swiggy_clone.ui.common_composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyOrangePrimary
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyOrangeSecondary

@Composable
fun SwiggyPrimaryButton(text: String, onCLick: () -> Unit) {
    Text(
        text = text,
        modifier = Modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(SwiggyOrangePrimary)
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .clickable {
                onCLick()
            },
        color = SwiggyOrangeSecondary
    )
}