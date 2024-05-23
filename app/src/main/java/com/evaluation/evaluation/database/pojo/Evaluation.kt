package com.evaluation.evaluation.database.pojo

import android.provider.ContactsContract

data class Evaluation(
    val id: String,
    val serviceId: String,
    val userId: String,
    val content: String,
    val level: Int,
    val time: String
)