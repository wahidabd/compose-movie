package com.wahidabd.composemovie.core

sealed class Resource <out T> {
    class Loading<out T> : Resource<T>()
    class Empty<out T> : Resource<T>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error<out T>(val e: String) : Resource<T>()
}