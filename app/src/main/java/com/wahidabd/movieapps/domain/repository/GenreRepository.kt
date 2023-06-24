package com.wahidabd.movieapps.domain.repository

import com.wahidabd.library.data.Resource
import com.wahidabd.movieapps.data.remote.response.WrapperGenreResponse
import com.wahidabd.movieapps.utils.MovieType
import kotlinx.coroutines.flow.Flow


/**
 * Created by Wahid on 6/24/2023.
 * Github github.com/wahidabd.
 */


interface GenreRepository {
    fun getMovieGenre(movieType: MovieType): Flow<Resource<WrapperGenreResponse>>
}