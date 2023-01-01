package com.wahidabd.composemovie.data.model

data class MovieDetail(
    val adult: Boolean,
    val backdrop_path: String,
    val genres: List<GenreModel>,
    val id: String,
    val vote_count: String,
    val original_state: String,
    val overview: String,
    val original_language: String,
    val runtime: String,
    val poster_path: String,
    val release_date: String,
    val vote_average: String
)
