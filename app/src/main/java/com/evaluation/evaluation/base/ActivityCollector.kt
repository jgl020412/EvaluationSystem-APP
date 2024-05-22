package com.evaluation.evaluation.base

import android.app.Activity
import java.lang.ref.WeakReference

object ActivityCollector {
    private val activities = ArrayList<WeakReference<Activity>>()

    fun addActivity(activity: WeakReference<Activity>) {
        activities.add(activity)
    }

    fun removeActivity(activity: WeakReference<Activity>) {
        activities.remove(activity)
    }

    fun finishAll() {
        if (activities.isNotEmpty()) {
            for (activityWeak in activities) {
                val activity = activityWeak.get()
                if (activity != null && !activity.isFinishing) {
                    activity.finish()
                }
            }
            activities.clear()
        }
    }

}