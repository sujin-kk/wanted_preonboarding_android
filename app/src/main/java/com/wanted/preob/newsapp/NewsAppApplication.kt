package com.wanted.preob.newsapp

import android.app.Application
import timber.log.Timber

class NewsAppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}