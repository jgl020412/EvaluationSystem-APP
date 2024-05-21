package com.evaluation.evaluation.util

import android.content.Context
import android.content.SharedPreferences
import com.evaluation.evaluation.App

object SharedPreferenceHelper {

    private val mPreferences: SharedPreferences

    init {
        mPreferences = App.context.getSharedPreferences(Constants.FILE_NAME, Context.MODE_PRIVATE)
    }

    fun putString(key: String, msg: String) {
        val editor = mPreferences.edit()
        editor.putString(key, msg)
        editor.apply()
    }

    fun putBoolean(key: String, msg: Boolean) {
        val editor = mPreferences.edit()
        editor.putBoolean(key, msg)
        editor.apply()
    }

    fun loadStr(key: String, defaultStr: String) : String? {
        return mPreferences.getString(key, defaultStr)
    }

    fun loadBoolean(key: String, default: Boolean) = mPreferences.getBoolean(key, default)

}