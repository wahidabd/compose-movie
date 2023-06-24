package com.wahidabd.movieapps.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.wahidabd.movieapps.data.remote.ApiService
import com.wahidabd.movieapps.data.remote.response.MovieResponse
import retrofit2.HttpException
import java.io.IOException


/**
 * Created by Wahid on 6/24/2023.
 * Github github.com/wahidabd.
 */


class UpcomingMoviePagingSource(
    private val api: ApiService,
) : PagingSource<Int, MovieResponse>() {

    override fun getRefreshKey(state: PagingState<Int, MovieResponse>): Int? =
        state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieResponse> =
        try {
            val position = params.key ?: 1
            val result = api.getUpcomingMovies(position).results

            LoadResult.Page(
                data = result,
                prevKey = if (position == 1) null else position.minus(1),
                nextKey = if (result.isEmpty()) null else position.plus(1)
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
}