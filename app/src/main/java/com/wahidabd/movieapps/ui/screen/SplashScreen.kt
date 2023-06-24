package com.wahidabd.movieapps.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.LottieOnCompositionLoadedListener
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.wahidabd.movieapps.R
import com.wahidabd.movieapps.ui.screen.destinations.HomeScreenDestination
import com.wahidabd.movieapps.ui.theme.AppPrimaryColor
import kotlinx.coroutines.delay


/**
 * Created by Wahid on 6/23/2023.
 * Github github.com/wahidabd.
 */


@RootNavGraph(start = true)
@Destination()
@Composable
fun SplashScreen(
    navigator: DestinationsNavigator?
) {

    var animate by remember { mutableStateOf(false) }
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.bubble))


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(AppPrimaryColor)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            LottieAnimation(composition = composition)
            LaunchedEffect(Unit){
                delay(2000)
                animate = true
                delay(2000)
                navigator?.popBackStack()
                navigator?.navigate(HomeScreenDestination)
            }

            this@Column.AnimatedVisibility(
                visible = animate.not(),
                exit = fadeOut(
                    animationSpec = tween(durationMillis = 2000)
                ) + scaleOut(animationSpec = tween(durationMillis = 2000)),
            ) {
                Image(
                    modifier = Modifier
                        .widthIn(max = 170.dp)
                        .alpha(0.78F),
                    painter = painterResource(id = R.drawable.neatflix_name),
                    contentDescription = null
                )
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(null)
}