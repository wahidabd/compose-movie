package com.wahidabd.movieapps.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController


/**
 * Created by Wahid on 6/22/2023.
 * Github github.com/wahidabd.
 */


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph(
    navController: NavHostController
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Destinations.Movie.route
    ) {
        composable(Destinations.Movie.route) { MoviesScreenGraph() }
        composable(Destinations.Favorite.route) { FavoriteScreenGraph() }
        profileScreen()
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MoviesScreenGraph(navController: NavHostController = rememberAnimatedNavController()) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Destinations.MovieDiscover.route
    ) {
        composable(
            Destinations.MovieDiscover.route,
            enterTransition = {
                when (initialState.destination.route) {
                    Destinations.MovieDetails.route ->
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    Destinations.MovieDetails.route ->
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    Destinations.MovieDetails.route ->
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    Destinations.MovieDetails.route ->
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            }
        ) {
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FavoriteScreenGraph(navController: NavHostController = rememberAnimatedNavController()) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Destinations.FavoriteDiscover.route
    ) {
        composable(
            Destinations.FavoriteDiscover.route,
            enterTransition = {
                when (initialState.destination.route) {
                    Destinations.FavoriteDetails.route ->
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    Destinations.FavoriteDetails.route ->
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    Destinations.FavoriteDetails.route ->
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    Destinations.FavoriteDetails.route ->
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            }
        ) {
            // wite code here...
        }

        composable(
            Destinations.FavoriteDetails.route,
            enterTransition = {
                when (initialState.destination.route) {
                    Destinations.FavoriteDiscover.route ->
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    Destinations.FavoriteDiscover.route ->
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    Destinations.FavoriteDiscover.route ->
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    Destinations.FavoriteDiscover.route ->
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            }
        ) {
            // write code here...
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.profileScreen() {
    composable(Destinations.Profile.route) {

    }
}