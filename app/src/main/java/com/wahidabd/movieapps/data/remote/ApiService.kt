package com.wahidabd.movieapps.data.remote

import com.wahidabd.movieapps.data.remote.response.CastResponse
import com.wahidabd.movieapps.data.remote.response.GenreResponse
import com.wahidabd.movieapps.data.remote.response.MovieResponse
import com.wahidabd.movieapps.data.remote.response.WrapperPagingResponse
import com.wahidabd.movieapps.data.remote.response.WatchProviderResponse
import com.wahidabd.movieapps.data.remote.response.WrapperCastResponse
import com.wahidabd.movieapps.data.remote.response.WrapperGenreResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Created by Wahid on 6/24/2023.
 * Github github.com/wahidabd.
 */


interface ApiService {

    @GET("trending/movie/day")
    suspend fun getTrendingMovies(
        @Query("page") page: Int = 0,
    ): WrapperPagingResponse<MovieResponse>

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int = 0,
    ): WrapperPagingResponse<MovieResponse>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("page") page: Int = 0,
    ): WrapperPagingResponse<MovieResponse>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("page") page: Int = 0,
    ): WrapperPagingResponse<MovieResponse>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("page") page: Int = 0,
    ): WrapperPagingResponse<MovieResponse>

    @GET("movie/{movie_id}/recommendations")
    suspend fun getRecommendedMovies(
        @Path("movie_id") movieId: Int,
        @Query("page") page: Int = 0,
    ): WrapperPagingResponse<MovieResponse>

    @GET("movie/{movie_id}/similar")
    suspend fun getSimilarMovies(
        @Path("movie_id") filmId: Int,
        @Query("page") page: Int = 0,
    ): WrapperPagingResponse<MovieResponse>

    @GET("discover/movie?")
    suspend fun getBackInTheDaysMovies(
        @Query("page") page: Int = 0,
        @Query("primary_release_date.gte") gteReleaseDate: String = "1940-01-01",
        @Query("primary_release_date.lte") lteReleaseDate: String = "1981-01-01",
        @Query("sort_by") sortBy: String = "vote_count.desc"
    ): WrapperPagingResponse<MovieResponse>

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCast(
        @Path("movie_id") filmId: Int,
    ): Response<WrapperCastResponse>

    @GET("genre/movie/list")
    suspend fun getMovieGenres(): Response<WrapperGenreResponse>

    @GET("search/multi")
    suspend fun multiSearch(
        @Query("query") searchParams: String,
        @Query("page") page: Int = 0,
        @Query("include_adult") includeAdult: Boolean = true,
    ): WrapperPagingResponse<MovieResponse>

    @GET("genre/tv/list")
    suspend fun getTvShowGenres(
    ): Response<WrapperGenreResponse>

    @GET("tv/{tv_id}/credits")
    suspend fun getTvShowCast(
        @Path("tv_id") filmId: Int,
    ): Response<CastResponse>

    @GET("tv/{tv_id}/similar")
    suspend fun getSimilarTvShows(
        @Path("tv_id") filmId: Int,
        @Query("page") page: Int = 0,
    ): WrapperPagingResponse<MovieResponse>

    @GET("trending/tv/day")
    suspend fun getTrendingTvSeries(
        @Query("page") page: Int = 0,
    ): WrapperPagingResponse<MovieResponse>

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query("page") page: Int = 0,
    ): WrapperPagingResponse<MovieResponse>


    @GET("tv/top_rated")
    suspend fun getTopRatedTvShows(
        @Query("page") page: Int = 0,
    ): WrapperPagingResponse<MovieResponse>

    @GET("tv/on_the_air")
    suspend fun getOnTheAirTvShows(
        @Query("page") page: Int = 0,
    ): WrapperPagingResponse<MovieResponse>

    @GET("tv/{tv_id}/recommendations")
    suspend fun getRecommendedTvShows(
        @Path("tv_id") filmId: Int,
        @Query("page") page: Int = 0,
    ): WrapperPagingResponse<MovieResponse>

    @GET("discover/tv?")
    suspend fun getBackInTheDaysTvShows(
        @Query("page") page: Int = 0,
        @Query("first_air_date.gte") gteFirstAirDate: String = "1940-01-01",
        @Query("first_air_date.lte") lteFirstAirDate: String = "1981-01-01",
        @Query("sort_by") sortBy: String = "vote_count.desc"
    ): WrapperPagingResponse<MovieResponse>

    /** Reviews*/
    @GET("{film_path}/{film_id}/reviews?")
    suspend fun getMovieReviews(
        @Path("film_id") filmId: Int,
        @Path("film_path") filmPath: String,
        @Query("page") page: Int = 0,
    ): WrapperPagingResponse<MovieResponse>

    /** Watch providers (US only)*/

    @GET("{film_path}/{film_id}/watch/providers?")
    suspend fun getWatchProviders(
        @Path("film_path") filmPath: String,
        @Path("film_id") filmId: Int,
    ): Response<WatchProviderResponse>

}