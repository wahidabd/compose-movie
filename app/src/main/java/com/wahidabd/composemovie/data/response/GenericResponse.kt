package com.wahidabd.composemovie.data.response

import com.google.gson.annotations.SerializedName

data class GenericResponse(
    val success: Boolean,
    val status_code: Int,
    @SerializedName("status_message")
    val message: String
)
