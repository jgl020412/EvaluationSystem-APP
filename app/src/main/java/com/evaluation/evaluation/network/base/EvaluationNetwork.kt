package com.evaluation.evaluation.network.base

import com.evaluation.evaluation.model.pojo.UserBO
import com.evaluation.evaluation.network.service.EvaluationService
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

    fun getServices() = servService.getServiceList()

    /* 有关评价的服务 */
    private val evaluationService = ServiceCreator.create("eval", EvaluationService::class.java)

    fun getAllEvaluation() = evaluationService.getAllEvaluation()

    fun getMyEvaluation(userId: String) = evaluationService.getMyEvaluation(userId);

}