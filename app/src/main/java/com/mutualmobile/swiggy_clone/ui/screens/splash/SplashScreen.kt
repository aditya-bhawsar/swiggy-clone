package com.mutualmobile.swiggy_clone.ui.screens.splash

import android.app.Activity
import android.provider.Settings
import androidx.compose.animation.core.AnimationConstants
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onAnimationFinish: () -> Unit,
) {

    LaunchedEffect(Unit) {
        delay(1500)
        onAnimationFinish()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        val swiggyImageResource = painterResource(id = R.drawable.ic_swiggy)
        Image(
            modifier = Modifier.width(swiggyImageResource.intrinsicSize.width.dp),
            painter = swiggyImageResource,
            contentDescription = "splashScreen"
        )
    }
}
