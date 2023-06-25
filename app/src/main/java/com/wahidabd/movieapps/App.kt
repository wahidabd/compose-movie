package com.wahidabd.movieapps

import com.wahidabd.library.presentation.BaseApplication
import com.wahidabd.movieapps.di.appModule
import com.wahidabd.movieapps.di.domainModule
import com.wahidabd.movieapps.di.repoModule
import com.wahidabd.movieapps.di.sourceModule
import com.wahidabd.movieapps.di.viewModelModule
import org.koin.core.module.Module
import timber.log.Timber


/**
 * Created by Wahid on 6/24/2023.
 * Github github.com/wahidabd.
 */


class App : BaseApplication() {

    override fun getDefineModule(): List<Module> =
        listOf(
            appModule,
            sourceModule,
            repoModule,
            domainModule,
            viewModelModule
        )

    override fun initApp() {
        Timber.plant(Timber.DebugTree())
    }
}