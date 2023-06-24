package com.wahidabd.movieapps.data.remote.response

import com.google.gson.annotations.SerializedName


/**
 * Created by Wahid on 6/24/2023.
 * Github github.com/wahidabd.
 */


data class PagingResponse<T>(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<T>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)