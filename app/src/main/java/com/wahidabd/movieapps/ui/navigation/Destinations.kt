package com.wahidabd.movieapps.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.wahidabd.movieapps.R


/**
 * Created by Wahid on 6/22/2023.
 * Github github.com/wahidabd.
 */


sealed class Destinations(
    val route: String,
    val suRoute: String?,
    @StringRes
    val title: Int?,
    val icon: ImageVector?
) {
    companion object {
        val navScreenList = listOf(Movie, Favorite, Profile)
    }

    object Movie : Destinations(
        "movie_screen",
        "movie_discover_screen",
        R.string.nav_title_movies,
        Icons.Default.PlayArrow
    )

    object MovieDiscover : Destinations(
        "MoviesDiscoverScreen",
        null,
        null,
        null
    )

    object MovieDetails : Destinations(
        "MovieDetailsScreen/{movieId}",
        null,
        null,
        null
    )

    object Favorite : Destinations(
        "FavoriteMoviesScreen",
        "FavoriteDiscoverScreen",
        R.string.nav_title_favorites,
        Icons.Default.Star
    )

    object FavoriteDiscover : Destinations(
        "FavoriteDiscoverScreen",
        null,
        null,
        null
    )

    object FavoriteDetails : Destinations(
        "FavoriteDetailsScreen/{movieId}",
        null,
        null,
        null
    )

    object Profile : Destinations(
        "UserProfileScreen",
        null,
        R.string.nav_title_profile,
        Icons.Default.Person
    )

}