package com.wahidabd.movieapps.domain.movie

import androidx.paging.PagingData
import com.wahidabd.library.data.Resource
import com.wahidabd.movieapps.data.remote.response.WatchProviderResponse
import com.wahidabd.movieapps.data.remote.source.movie.MovieRepository
import com.wahidabd.movieapps.domain.model.Cast
import com.wahidabd.movieapps.domain.model.Movie
import com.wahidabd.movieapps.utils.MovieType
import kotlinx.coroutines.flow.Flow


/**
 * Created by Wahid on 6/25/2023.
 * Github github.com/wahidabd.
 */


class MovieInteractor(
    private val repository: MovieRepository
) : MovieUseCase {

    override fun getTrendingMovie(movieType: MovieType): Flow<PagingData<Movie>> =
        repository.getTrendingMovie(movieType)

    override fun getPopularMovie(movieType: MovieType): Flow<PagingData<Movie>> =
        repository.getPopularMovie(movieType)

    override fun getTopRatedMovie(movieType: MovieType): Flow<PagingData<Movie>> =
        repository.getTopRatedMovie(movieType)

    override fun getNowPlayingMovie(movieType: MovieType): Flow<PagingData<Movie>> =
        repository.getNowPlayingMovie(movieType)

    override fun getUpcomingMovie(): Flow<PagingData<Movie>> =
        repository.getUpcomingMovie()

    override fun getBackInTheDayMovie(movieType: MovieType): Flow<PagingData<Movie>> =
        repository.getBackInTheDayMovie(movieType)

    override fun getSimilarMovie(movieType: MovieType, id: Int): Flow<PagingData<Movie>> =
        repository.getSimilarMovie(movieType, id)

    override fun getRecommendedMovie(movieType: MovieType, id: Int): Flow<PagingData<Movie>> =
        repository.getRecommendedMovie(movieType, id)

    override fun getMovieCast(id: Int, movieType: MovieType): Flow<Resource<List<Cast>>> =
        repository.getMovieCast(id, movieType)

    override fun getWatchProvider(
        id: Int,
        movieType: MovieType
    ): Flow<Resource<WatchProviderResponse>> =
        repository.getWatchProvider(id, movieType)
}