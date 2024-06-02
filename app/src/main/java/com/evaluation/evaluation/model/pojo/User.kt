package com.evaluation.evaluation.model.pojo

data class User(
    val id: String,
    var name: String,
    var password: String,
    var phoneNum: String,
    var mail: String,
    var idNum: String,
    var job: String,
    var sex: Int,
    var birthday: String,
    var province: String,
    var city: String,
    var district: String,
    var status: Int
)