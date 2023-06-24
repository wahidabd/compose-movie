package com.wahidabd.movieapps.data.remote.response

import com.google.gson.annotations.SerializedName


/**
 * Created by Wahid on 6/24/2023.
 * Github github.com/wahidabd.
 */


data class WrapperCastResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("cast")
    val castResult: List<CastResponse>
)
