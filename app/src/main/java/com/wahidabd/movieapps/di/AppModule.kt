package com.wahidabd.movieapps.di

import com.wahidabd.library.data.libs.ApiService
import com.wahidabd.library.data.libs.OkHttpClientFactory
import com.wahidabd.library.data.libs.interceptor.HeaderInterceptor
import com.wahidabd.library.utils.coroutine.handler.ErrorParses
import com.wahidabd.movieapps.BuildConfig
import okhttp3.Interceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module


/**
 * Created by Wahid on 6/24/2023.
 * Github github.com/wahidabd.
 */


const val BASE_URL = ""

val appModule = module {
    single {
        return@single OkHttpClientFactory.create(
            interceptors = listOf(addHeaderInterceptor()),
            showDebugLog = BuildConfig.DEBUG,
            certificatePinner = null,
            authenticator = null
        )
    }

    single(named(BASE_URL)) {
        BuildConfig.BASE_URL
    }

    single {
        ApiService.createService(
            get(), get(named(BASE_URL))
        )
    }

    factory { ErrorParses(get()) }
}

private fun addHeaderInterceptor(): Interceptor {
    val headers = HashMap<String, String>()
    headers["Accept"] = "application/json"
    headers["Content-Type"] = "application/json"
    headers["Authorization"] = BuildConfig.BUILD_TYPE
    return HeaderInterceptor(headers)
}