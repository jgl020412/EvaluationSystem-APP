package com.evaluation.evaluation.model.pojo

data class UserBO (
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
    val status: Int,
    val smsCode: String,
)