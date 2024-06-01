package com.evaluation.evaluation.login

import android.app.Application
import com.evaluation.evaluation.model.pojo.UserBO
import com.evaluation.evaluation.network.base.EvaluationNetwork
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class RegisterRepository @Inject constructor(val application: Application) {
    suspend fun doRegister(userBO: UserBO) = EvaluationNetwork.doLogin(userBO)
}