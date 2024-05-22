package com.evaluation.evaluation

import android.app.Application
import android.content.Context
import android.view.View

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