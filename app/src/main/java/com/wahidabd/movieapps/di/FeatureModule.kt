package com.wahidabd.movieapps.di

import com.wahidabd.movieapps.data.remote.ApiService
import com.wahidabd.movieapps.data.remote.source.genre.GenreDataSource
import com.wahidabd.movieapps.data.remote.source.genre.GenreRepository
import com.wahidabd.movieapps.data.remote.source.genre.GenreRepositoryImpl
import com.wahidabd.movieapps.data.remote.source.movie.MovieDataSource
import com.wahidabd.movieapps.data.remote.source.movie.MovieRepository
import com.wahidabd.movieapps.data.remote.source.movie.MovieRepositoryImpl
import com.wahidabd.movieapps.domain.genre.GenreInteractor
import com.wahidabd.movieapps.domain.genre.GenreUseCase
import com.wahidabd.movieapps.domain.movie.MovieInteractor
import com.wahidabd.movieapps.domain.movie.MovieUseCase
import com.wahidabd.movieapps.ui.screen.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


/**
 * Created by Wahid on 6/24/2023.
 * Github github.com/wahidabd.
 */


val sourceModule = module {
    single { get<Retrofit>().create(ApiService::class.java) }
    single { MovieDataSource(get(), get()) }
    single { GenreDataSource(get(), get()) }
}

val repoModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    single<GenreRepository> { GenreRepositoryImpl(get()) }
}

val domainModule = module {
    single<MovieUseCase> { MovieInteractor(get()) }
    single<GenreUseCase> { GenreInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get(), get()) }
}