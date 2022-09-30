import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.common.composable.SpacerComponent
import com.mutualmobile.swiggy_clone.navigator.ComposeNavigator
import com.mutualmobile.swiggy_clone.ui.theme.SwiggyOrderConfirmationBlue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ConfirmationScreen(
    widthSizeClass: WindowWidthSizeClass,
    composeNavigator: ComposeNavigator,
) {
    val animationDuration = 2000
    var orderConfirmed by remember {
        mutableStateOf(false)
    }
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(key1 = true) {
        coroutineScope.launch {
            delay(2000L)
            orderConfirmed = true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OrderConfirmationIndicator(orderConfirmed)
        if (!orderConfirmed) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SpacerComponent(dimensionResourceId = R.dimen.height_large)
                Text(
                    text = stringResource(id = R.string.hold_on),
                    color = SwiggyOrderConfirmationBlue,
                    style = MaterialTheme.typography.bodyLarge
                )
                SpacerComponent(dimensionResourceId = R.dimen.height_medium)
                Text(
                    text = stringResource(id = R.string.verifying_payment),
                    color = SwiggyOrderConfirmationBlue,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
        AnimatedVisibility(
            visible = orderConfirmed,
            enter = fadeIn(animationSpec = tween(durationMillis = animationDuration)),
            exit = fadeOut(animationSpec = tween(durationMillis = animationDuration))
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SpacerComponent(dimensionResourceId = R.dimen.height_large)
                Text(
                    text = stringResource(id = R.string.order_confirmation),
                    color = SwiggyOrderConfirmationBlue,
                    style = MaterialTheme.typography.bodyLarge
                )
                SpacerComponent(dimensionResourceId = R.dimen.height_medium)
                Text(
                    text = stringResource(id = R.string.order_confirmation_description),
                    color = SwiggyOrderConfirmationBlue,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
fun OrderConfirmationIndicator(orderConfirmed: Boolean) {
    val strokeWidth = 8.dp

    if (!orderConfirmed) {
        Box(modifier = Modifier.size(200.dp), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                strokeWidth = strokeWidth,
                color = SwiggyOrderConfirmationBlue,
                modifier = Modifier.size(200.dp)
            )
        }
    } else {
        Image(
            painter = painterResource(id = R.drawable.ic_check), contentDescription = "",
            modifier = Modifier.size(200.dp)
        )
    }
}

@Preview
@Composable
fun IndicatorPreview() {
    OrderConfirmationIndicator(orderConfirmed = true)
}