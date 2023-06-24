package com.wahidabd.movieapps.data.remote.source.movie

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.wahidabd.library.data.Resource
import com.wahidabd.library.utils.coroutine.enqueue
import com.wahidabd.library.utils.coroutine.handler.ErrorParses
import com.wahidabd.movieapps.data.remote.ApiService
import com.wahidabd.movieapps.data.remote.paging.BackInTheDaysMoviePagingSource
import com.wahidabd.movieapps.data.remote.paging.NowPlayingMoviePagingSource
import com.wahidabd.movieapps.data.remote.paging.PopularMoviePagingSource
import com.wahidabd.movieapps.data.remote.paging.RecommendedMoviePagingSource
import com.wahidabd.movieapps.data.remote.paging.SimilarMoviePagingSource
import com.wahidabd.movieapps.data.remote.paging.TopRatedMoviePagingSource
import com.wahidabd.movieapps.data.remote.paging.TrendingMoviePagingSource
import com.wahidabd.movieapps.data.remote.paging.UpcomingMoviePagingSource
import com.wahidabd.movieapps.data.remote.response.MovieResponse
import com.wahidabd.movieapps.data.remote.response.WatchProviderResponse
import com.wahidabd.movieapps.data.remote.response.WrapperCastResponse
import com.wahidabd.movieapps.utils.MovieType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


/**
 * Created by Wahid on 6/24/2023.
 * Github github.com/wahidabd.
 */


class MovieDataSource(
    private val api: ApiService,
    private val error: ErrorParses
) {

    fun getTrendingMovie(movieType: MovieType): Flow<PagingData<MovieResponse>> =
        Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = { TrendingMoviePagingSource(api, movieType) }
        ).flow

    fun getPopularMovie(movieType: MovieType): Flow<PagingData<MovieResponse>> =
        Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = { PopularMoviePagingSource(api, movieType) }
        ).flow

    fun getTopRatedMovie(movieType: MovieType): Flow<PagingData<MovieResponse>> =
        Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = { TopRatedMoviePagingSource(api, movieType) }
        ).flow

    fun getNowPlayingMovie(movieType: MovieType): Flow<PagingData<MovieResponse>> =
        Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = { NowPlayingMoviePagingSource(api, movieType) }
        ).flow


    fun getUpcomingMovie(): Flow<PagingData<MovieResponse>> =
        Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = { UpcomingMoviePagingSource(api) }
        ).flow

    fun getBackInTheDayMovie(movieType: MovieType): Flow<PagingData<MovieResponse>> =
        Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = { BackInTheDaysMoviePagingSource(api, movieType) }
        ).flow

    fun getSimilarMovie(movieType: MovieType, id: Int): Flow<PagingData<MovieResponse>> =
        Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = { SimilarMoviePagingSource(api, movieType, id) }
        ).flow

    fun getRecommendedMovie(movieType: MovieType, id: Int): Flow<PagingData<MovieResponse>> =
        Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = { RecommendedMoviePagingSource(api, movieType, id) }
        ).flow

    suspend fun getMovieCast(id: Int, movieType: MovieType): Flow<Resource<WrapperCastResponse>> =
        flow {
            when (movieType) {
                MovieType.MOVIE -> enqueue(
                    id,
                    error::convertGenericError,
                    api::getMovieCast,
                    onEmit = { it }
                )

                MovieType.TV -> enqueue(
                    id,
                    error::convertGenericError,
                    api::getTvShowCast,
                    onEmit = { it }
                )
            }
        }

    suspend fun getWatchProvider(
        id: Int,
        movieType: MovieType
    ): Flow<Resource<WatchProviderResponse>> = flow {
        when (movieType) {
            MovieType.MOVIE -> enqueue(
                "movie",
                id,
                error::convertGenericError,
                api::getWatchProviders,
                onEmit = { it }
            )

            MovieType.TV -> enqueue(
                "tv",
                id,
                error::convertGenericError,
                api::getWatchProviders,
                onEmit = { it }
            )
        }
    }

}