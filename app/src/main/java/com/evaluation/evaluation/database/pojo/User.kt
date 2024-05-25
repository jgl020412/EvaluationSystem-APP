package com.evaluation.evaluation.database.pojo

data class User(
    val id: String,
    val name: String,
    val password: String,
    val phoneNum: String,
    val mail: String,
    val idNum: String,
    val job: String,
    val sex: Int,
    val birthday: String,
    val province: String,
    val city: String,
    val district: String,
    val status: Int
)