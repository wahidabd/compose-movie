package com.wahidabd.movieapps.data.remote.source.movie

import androidx.paging.PagingData
import androidx.paging.map
import com.wahidabd.library.data.Resource
import com.wahidabd.library.utils.coroutine.boundResource.InternetBoundResource
import com.wahidabd.movieapps.data.remote.response.WatchProvider
import com.wahidabd.movieapps.data.remote.response.WatchProviderResponse
import com.wahidabd.movieapps.data.remote.response.WrapperCastResponse
import com.wahidabd.movieapps.domain.mapper.toDomain
import com.wahidabd.movieapps.domain.model.Cast
import com.wahidabd.movieapps.domain.model.Movie
import com.wahidabd.movieapps.domain.repository.MovieRepository
import com.wahidabd.movieapps.utils.MovieType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


/**
 * Created by Wahid on 6/24/2023.
 * Github github.com/wahidabd.
 */


class MovieRepositoryImpl(
    private val source: MovieDataSource,
) : MovieRepository {

    override fun getTrendingMovie(movieType: MovieType): Flow<PagingData<Movie>> =
        source.getTrendingMovie(movieType).map {
            it.map { movie ->
                movie.toDomain()
            }
        }

    override fun getPopularMovie(movieType: MovieType): Flow<PagingData<Movie>> =
        source.getPopularMovie(movieType).map {
            it.map { movie ->
                movie.toDomain()
            }
        }

    override fun getTopRatedMovie(movieType: MovieType): Flow<PagingData<Movie>> =
        source.getTopRatedMovie(movieType).map {
            it.map { movie ->
                movie.toDomain()
            }
        }

    override fun getNowPlayingMovie(movieType: MovieType): Flow<PagingData<Movie>> =
        source.getNowPlayingMovie(movieType).map {
            it.map { movie ->
                movie.toDomain()
            }
        }

    override fun getUpcomingMovie(): Flow<PagingData<Movie>> =
        source.getUpcomingMovie().map {
            it.map { movie ->
                movie.toDomain()
            }
        }

    override fun getBackInTheDayMovie(movieType: MovieType): Flow<PagingData<Movie>> =
        source.getBackInTheDayMovie(movieType).map {
            it.map { movie ->
                movie.toDomain()
            }
        }

    override fun getSimilarMovie(movieType: MovieType, id: Int): Flow<PagingData<Movie>> =
        source.getSimilarMovie(movieType, id).map {
            it.map { movie ->
                movie.toDomain()
            }
        }

    override fun getRecommendedMovie(movieType: MovieType, id: Int): Flow<PagingData<Movie>> =
        source.getRecommendedMovie(movieType, id).map {
            it.map { movie ->
                movie.toDomain()
            }
        }

    override suspend fun getMovieCast(id: Int, movieType: MovieType): Flow<Resource<List<Cast>>> =
        object : InternetBoundResource<List<Cast>, WrapperCastResponse>() {
            override suspend fun createCall(): Flow<Resource<WrapperCastResponse>> {
                return source.getMovieCast(id, movieType)
            }

            override suspend fun saveCallRequest(data: WrapperCastResponse): List<Cast> {
                return data.castResult.map {
                    it.toDomain()
                }
            }

        }.asFlow()

    override suspend fun getWatchProvider(
        id: Int,
        movieType: MovieType
    ): Flow<Resource<WatchProviderResponse>> {
        return source.getWatchProvider(id, movieType)
    }
}