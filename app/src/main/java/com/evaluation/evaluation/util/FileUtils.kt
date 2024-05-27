package com.evaluation.evaluation.util

import android.content.res.Resources
import java.util.Properties

fun readProperties(resources: Resources?, resourceId: Int): Properties {
    val properties = Properties()
    val inputStream = resources?.openRawResource(resourceId)
    properties.load(inputStream)
    inputStream?.close()
    return properties
}