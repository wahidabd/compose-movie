package com.wahidabd.movieapps.data.remote.source.genre

import com.wahidabd.library.data.Resource
import com.wahidabd.library.utils.coroutine.enqueue
import com.wahidabd.library.utils.coroutine.handler.ErrorParses
import com.wahidabd.movieapps.data.remote.ApiService
import com.wahidabd.movieapps.data.remote.response.WrapperGenreResponse
import com.wahidabd.movieapps.utils.MovieType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


/**
 * Created by Wahid on 6/24/2023.
 * Github github.com/wahidabd.
 */


class GenreDataSource(
    private val api: ApiService,
    private val error: ErrorParses
) {

    suspend fun getMovieGenre(movieType: MovieType): Flow<Resource<WrapperGenreResponse>> = flow {
        when (movieType) {
            MovieType.MOVIE -> enqueue(
                error::convertGenericError,
                api::getMovieGenres,
                onEmit = { it })

            MovieType.TV -> enqueue(
                error::convertGenericError,
                api::getTvShowGenres,
                onEmit = { it })
        }
    }

}