package com.wahidabd.movieapps.domain.genre

import com.wahidabd.library.data.Resource
import com.wahidabd.movieapps.data.remote.response.WrapperGenreResponse
import com.wahidabd.movieapps.utils.MovieType
import kotlinx.coroutines.flow.Flow


/**
 * Created by Wahid on 6/25/2023.
 * Github github.com/wahidabd.
 */


interface GenreUseCase {
    fun getMovieGenre(movieType: MovieType): Flow<Resource<WrapperGenreResponse>>
}