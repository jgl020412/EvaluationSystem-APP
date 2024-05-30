package com.evaluation.evaluation.network.base

import com.evaluation.evaluation.App
import com.evaluation.evaluation.R
import com.evaluation.evaluation.util.MLog
import com.evaluation.evaluation.util.readProperties
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Properties

object ServiceCreator {

    private var properties: Properties

    init {
        val openRawResource = App.context.resources
        properties = readProperties(openRawResource, R.raw.service)
    }

    fun <T> create(url: String, service: Class<T>): T = create(url).create(service)

    private fun create(url: String): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl(properties["${url}.url"].toString())
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }

}