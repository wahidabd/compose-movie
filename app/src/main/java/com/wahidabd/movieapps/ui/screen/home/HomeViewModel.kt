package com.wahidabd.movieapps.ui.screen.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.wahidabd.library.data.Resource
import com.wahidabd.movieapps.domain.mapper.toDomain
import com.wahidabd.movieapps.domain.model.Genre
import com.wahidabd.movieapps.domain.model.Movie
import com.wahidabd.movieapps.data.remote.source.genre.GenreRepository
import com.wahidabd.movieapps.domain.movie.MovieUseCase
import com.wahidabd.movieapps.utils.MovieType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch


/**
 * Created by Wahid on 6/24/2023.
 * Github github.com/wahidabd.
 */


class HomeViewModel(
    private val movieUseCase: MovieUseCase,
    private val genreRepository: GenreRepository
) : ViewModel() {

    var randomMovieId: Int? = null

    private var _movieGenre = mutableStateListOf(Genre(null, "All"))
    var movieGenre: SnapshotStateList<Genre> = _movieGenre

    var selectedGenre: MutableState<Genre> = mutableStateOf(Genre(null, "All"))
    var selectedMovieType = mutableStateOf(MovieType.MOVIE)

    private val _trendingMovie = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val trendingMovie: State<Flow<PagingData<Movie>>> get() = _trendingMovie

    private val _popularMovie = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val popularMovie: State<Flow<PagingData<Movie>>> get() = _popularMovie

    private val _topRatedMovie = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val topRatedMovie: State<Flow<PagingData<Movie>>> get() = _topRatedMovie

    private val _nowPlayingMovie = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val nowPlayingMovie: State<Flow<PagingData<Movie>>> get() = _nowPlayingMovie

    private val _upcomingMovie = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val upcomingMovie: State<Flow<PagingData<Movie>>> get() = _upcomingMovie

    private val _backInTheDaysMovie = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val backInTheDaysMovie: State<Flow<PagingData<Movie>>> get() = _backInTheDaysMovie

    private val _recommendedMovie = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val recommendedMovie: State<Flow<PagingData<Movie>>> get() = _recommendedMovie

    fun refreshAll() {

    }

    fun getGenre(movieType: MovieType = selectedMovieType.value) {
        viewModelScope.launch {
            val defaultGenre = Genre(null, "All")
            genreRepository.getMovieGenre(movieType).collectLatest {
                when(it){
                    is Resource.Success -> {
                        _movieGenre.clear()
                        _movieGenre.add(defaultGenre)
                        selectedGenre.value = defaultGenre
                        it.data.genres.forEach { data ->
                            _movieGenre.add(data.toDomain())
                        }
                    }
                    else -> {}
                }
            }
        }
    }
}