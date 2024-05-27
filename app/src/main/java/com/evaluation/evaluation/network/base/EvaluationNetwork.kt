package com.evaluation.evaluation.network.base

import com.evaluation.evaluation.model.pojo.UserBO
import com.evaluation.evaluation.network.service.LoginService

object EvaluationNetwork {

    private val loginService = ServiceCreator.create("user", LoginService::class.java)

    suspend fun getSMSCode(mobile: String) = loginService.getSMSCode(mobile)
    suspend fun isExit(mobile: String, smsCode: String) = loginService.isExit(mobile, smsCode)
    suspend fun doLogin(userBO: UserBO) = loginService.doLogin(userBO)

}