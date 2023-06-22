package com.wahidabd.movieapps.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.wahidabd.movieapps.ui.theme.GoogleSans


/**
 * Created by Wahid on 6/22/2023.
 * Github github.com/wahidabd.
 */


@Composable
fun BottomNavBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry.value?.destination?.route

    Box(
        modifier.background(MaterialTheme.colorScheme.primary)
    ) {
        NavigationBar(containerColor = Color.Transparent) {
            Destinations.navScreenList.forEach { screen ->
                if (screen.title != null && screen.icon != null) {
                    NavigationBarItem(
                        label = { Text(stringResource(screen.title), fontFamily = GoogleSans) },
                        icon = {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = stringResource(screen.title)
                            )
                        },
                        selected = currentDestination == screen.route || currentDestination == screen.suRoute,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    }
}