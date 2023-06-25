package com.wahidabd.movieapps.data.remote.source.genre

import com.wahidabd.library.data.Resource
import com.wahidabd.library.utils.coroutine.boundResource.InternetBoundResource
import com.wahidabd.movieapps.data.remote.response.WrapperGenreResponse
import com.wahidabd.movieapps.domain.mapper.toDomain
import com.wahidabd.movieapps.domain.model.Genre
import com.wahidabd.movieapps.utils.MovieType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


/**
 * Created by Wahid on 6/24/2023.
 * Github github.com/wahidabd.
 */


class GenreRepositoryImpl(
    private val source: GenreDataSource
) : GenreRepository {

    override fun getMovieGenre(movieType: MovieType): Flow<Resource<WrapperGenreResponse>> = flow {
        object : InternetBoundResource<List<Genre>, WrapperGenreResponse>() {
            override suspend fun createCall(): Flow<Resource<WrapperGenreResponse>> {
                return source.getMovieGenre(movieType)
            }

            override suspend fun saveCallRequest(data: WrapperGenreResponse): List<Genre> {
                return data.genres.map {
                    it.toDomain()
                }
            }

        }.asFlow()
    }
}