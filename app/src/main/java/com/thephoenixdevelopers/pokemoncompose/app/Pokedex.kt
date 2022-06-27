package com.thephoenixdevelopers.pokemoncompose.app

import android.app.Application
import com.thephoenixdevelopers.pokemoncompose.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class Pokedex : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }

}