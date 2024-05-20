package com.evaluation.evaluation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.evaluation.evaluation.util.MLog

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MLog.d(TAG, javaClass.simpleName)
        ActivityCollector.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    companion object {
        private const val TAG = "BaseActivity"
    }

}