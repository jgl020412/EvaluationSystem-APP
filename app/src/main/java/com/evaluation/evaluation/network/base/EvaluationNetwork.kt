package com.evaluation.evaluation.network.base

import com.evaluation.evaluation.model.pojo.UserBO
import com.evaluation.evaluation.network.service.LoginService
import com.evaluation.evaluation.network.service.ServService

object EvaluationNetwork {

    /* 有关登录注册的服务 */

    private val loginService = ServiceCreator.create("user", LoginService::class.java)

    suspend fun getSMSCode(mobile: String) = loginService.getSMSCode(mobile)
    suspend fun isExit(mobile: String, smsCode: String) = loginService.isExit(mobile, smsCode)
    suspend fun doLogin(userBO: UserBO) = loginService.doLogin(userBO)

    /* 有关服务的服务 */

    private val servService = ServiceCreator.create("admin", ServService::class.java)

    suspend fun getServices() = servService.getServiceList()

}