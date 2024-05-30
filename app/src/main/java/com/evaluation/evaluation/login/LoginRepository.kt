package com.evaluation.evaluation.login

import android.app.Application
import com.evaluation.evaluation.model.pojo.UserBO
import com.evaluation.evaluation.network.base.EvaluationNetwork
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class LoginRepository @Inject constructor(val application: Application) {

    suspend fun isExit(mobile: String, smsCode: String) = EvaluationNetwork.isExit(mobile, smsCode)

    suspend fun doRegister(userBO: UserBO) = EvaluationNetwork.doLogin(userBO)

    suspend fun getSMSCode(mobile: String) = EvaluationNetwork.getSMSCode(mobile)

}