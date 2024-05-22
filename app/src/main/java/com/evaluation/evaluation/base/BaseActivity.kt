package com.evaluation.evaluation.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.evaluation.evaluation.util.MLog
import java.lang.ref.WeakReference

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MLog.d(TAG, javaClass.simpleName)
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                )
        ActivityCollector.addActivity(WeakReference(this))
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(WeakReference(this))
    }

    companion object {
        private const val TAG = "BaseActivity"
    }

}