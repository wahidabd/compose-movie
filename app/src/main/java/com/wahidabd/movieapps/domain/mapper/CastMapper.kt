package com.wahidabd.movieapps.domain.mapper

import com.wahidabd.movieapps.data.remote.response.CastResponse
import com.wahidabd.movieapps.domain.model.Cast


/**
 * Created by Wahid on 6/24/2023.
 * Github github.com/wahidabd.
 */


fun CastResponse.toDomain(): Cast =
    Cast(
        department = department,
        name = name,
        profilePath = profilePath
    )