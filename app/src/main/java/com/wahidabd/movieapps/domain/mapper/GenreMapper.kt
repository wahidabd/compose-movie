package com.wahidabd.movieapps.domain.mapper

import com.wahidabd.movieapps.data.remote.response.GenreResponse
import com.wahidabd.movieapps.domain.model.Genre


/**
 * Created by Wahid on 6/24/2023.
 * Github github.com/wahidabd.
 */


fun GenreResponse.toDomain(): Genre =
    Genre(
        id = id,
        name = name
    )