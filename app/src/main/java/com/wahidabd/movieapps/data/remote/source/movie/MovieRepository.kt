package com.wahidabd.movieapps.data.remote.source.movie

import androidx.paging.PagingData
import com.wahidabd.library.data.Resource
import com.wahidabd.movieapps.data.remote.response.WatchProvider
import com.wahidabd.movieapps.data.remote.response.WatchProviderResponse
import com.wahidabd.movieapps.domain.model.Cast
import com.wahidabd.movieapps.domain.model.Movie
import com.wahidabd.movieapps.utils.MovieType
import kotlinx.coroutines.flow.Flow


/**
 * Created by Wahid on 6/24/2023.
 * Github github.com/wahidabd.
 */


interface MovieRepository {

    fun getTrendingMovie(movieType: MovieType): Flow<PagingData<Movie>>
    fun getPopularMovie(movieType: MovieType): Flow<PagingData<Movie>>
    fun getTopRatedMovie(movieType: MovieType): Flow<PagingData<Movie>>
    fun getNowPlayingMovie(movieType: MovieType): Flow<PagingData<Movie>>
    fun getUpcomingMovie(): Flow<PagingData<Movie>>
    fun getBackInTheDayMovie(movieType: MovieType): Flow<PagingData<Movie>>
    fun getSimilarMovie(movieType: MovieType, id: Int): Flow<PagingData<Movie>>
    fun getRecommendedMovie(movieType: MovieType, id: Int): Flow<PagingData<Movie>>
    fun getMovieCast(id: Int, movieType: MovieType): Flow<Resource<List<Cast>>>
    fun getWatchProvider(id: Int, movieType: MovieType): Flow<Resource<WatchProviderResponse>>
}