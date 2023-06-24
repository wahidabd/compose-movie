package com.wahidabd.movieapps.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


/**
 * Created by Wahid on 6/24/2023.
 * Github github.com/wahidabd.
 */


@Parcelize
data class CastResponse(
    @SerializedName("known_for_department")
    val department: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("profile_path")
    val profilePath: String?
): Parcelable