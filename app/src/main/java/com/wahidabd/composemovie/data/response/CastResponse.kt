package com.wahidabd.composemovie.data.response

import com.wahidabd.composemovie.data.model.CastModel

data class CastResponse(
    val id: String,
    val cast: List<CastModel>
)