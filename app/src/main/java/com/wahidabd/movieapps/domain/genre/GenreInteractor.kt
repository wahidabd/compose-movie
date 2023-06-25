package com.wahidabd.movieapps.domain.genre

import com.wahidabd.library.data.Resource
import com.wahidabd.movieapps.data.remote.response.WrapperGenreResponse
import com.wahidabd.movieapps.data.remote.source.genre.GenreRepository
import com.wahidabd.movieapps.utils.MovieType
import kotlinx.coroutines.flow.Flow


/**
 * Created by Wahid on 6/25/2023.
 * Github github.com/wahidabd.
 */


class GenreInteractor(
    private val repository: GenreRepository
) : GenreUseCase {

    override fun getMovieGenre(movieType: MovieType): Flow<Resource<WrapperGenreResponse>> =
        repository.getMovieGenre(movieType)
}