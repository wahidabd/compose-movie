package com.wahidabd.movieapps.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ramcosta.composedestinations.DestinationsNavHost
import com.wahidabd.movieapps.ui.screen.NavGraphs
import com.wahidabd.movieapps.ui.theme.MovieAppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppsTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
