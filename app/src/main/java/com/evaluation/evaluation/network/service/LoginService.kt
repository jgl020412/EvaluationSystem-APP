package com.evaluation.evaluation.network.service

import com.evaluation.evaluation.model.model.BaseModel
import com.evaluation.evaluation.model.model.UserModel
import com.evaluation.evaluation.model.pojo.UserBO
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {
    @GET("/passport/getSMSCode")
    suspend fun getSMSCode(@Query("mobile") mobile: String): BaseModel<Int>

    @POST("/passport/isExit")
    suspend fun isExit(@Query("mobile") mobile: String, @Query("smsCode") smsCode: String): BaseModel<UserModel>

    @POST("/passport/doLogin")
    suspend fun doLogin(@Query("registerLoginBo") userBO: UserBO): BaseModel<UserModel>
}