package com.mutualmobile.swiggy_clone.ui.screens.cart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyOrangeText

@Composable
fun ReviewOrderPolicy() {
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
        SubHeaderText(header = stringResource(id = R.string.review_order))
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = buildAnnotatedString {
                append(
                    AnnotatedString(
                        stringResource(id = R.string.note),
                        spanStyle = SpanStyle(SwiggyOrangeText)
                    )
                )
                append(
                    AnnotatedString(
                        stringResource(id = R.string.policy),
                        spanStyle = SpanStyle(Color.Black)
                    )
                )
            }, style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = stringResource(id = R.string.avoid_cancellation),style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = R.string.read_policy),
                color = SwiggyOrangeText,
                textDecoration = TextDecoration.Underline,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.clickable {

                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}