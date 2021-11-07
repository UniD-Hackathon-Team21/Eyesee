package com.yblee2001.eyesee

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : MultiDexApplication() {

    companion object {
        lateinit var APP: Context
    }

    override fun onCreate() {
        super.onCreate()

        APP = this

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }

}