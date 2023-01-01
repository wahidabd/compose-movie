package com.wahidabd.composemovie.data.service

import com.wahidabd.composemovie.data.model.MovieDetail
import com.wahidabd.composemovie.data.response.CastResponse
import com.wahidabd.composemovie.data.response.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("movie/now_playing")
    suspend fun nowPlaying(): Response<MoviesResponse>

    @GET("movie/upcoming")
    suspend fun upcoming(): Response<MoviesResponse>

    @GET("movie/{movie_id}")
    suspend fun detail(
        @Path("movie_id") movie_id: String
    ): Response<MovieDetail>

    @GET("movie/{movie_id}/credits")
    suspend fun movieCast(
        @Path("movie_id") movie_id: String
    ): Response<CastResponse>

}