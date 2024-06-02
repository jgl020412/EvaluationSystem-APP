package com.evaluation.evaluation.network.service

import com.evaluation.evaluation.model.model.BaseModel
import com.evaluation.evaluation.model.pojo.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("/user/updateUserInfo")
    fun updateUserInfo(@Body user: User) : Call<BaseModel<Int>>

}