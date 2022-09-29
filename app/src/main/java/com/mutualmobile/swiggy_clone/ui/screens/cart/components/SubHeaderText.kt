package com.mutualmobile.swiggy_clone.ui.screens.cart.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.ui.theme.SwiggySubHeaderTextColor

@Composable
fun SubHeaderText(header: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = header,
            color = Color.Black,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
fun SubHeaderTextPreviewView() {
    SubHeaderText(header = stringResource(id = R.string.browse_restaurants))
}