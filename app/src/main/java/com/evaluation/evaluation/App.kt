package com.evaluation.evaluation

import android.app.Application
import android.content.Context

class App: Application() {
    companion object {
        @SuppressWarnings("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}