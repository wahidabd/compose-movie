package com.wahidabd.movieapps.domain.mapper

import com.wahidabd.movieapps.data.remote.response.MovieResponse
import com.wahidabd.movieapps.domain.model.Movie


/**
 * Created by Wahid on 6/24/2023.
 * Github github.com/wahidabd.
 */


fun MovieResponse.toDomain(): Movie =
    Movie(
        id = id,
        adult = adult,
        backdropPath = backdropPath,
        posterPath = posterPath,
        genreIds = genreIds,
        genres = genres?.map { it.toDomain() },
        mediaType = mediaType,
        imdbId = imdbId,
        originalLanguage = originalLanguage,
        overview = overview,
        popularity = popularity,
        releaseDate = releaseDate,
        runtime = runtime,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount
    )