package com.evaluation.evaluation.eval.my

import android.app.Application
import com.evaluation.evaluation.model.model.BaseModel
import com.evaluation.evaluation.model.model.EvaluationModel
import com.evaluation.evaluation.model.pojo.Evaluation
import com.evaluation.evaluation.model.pojo.User
import com.evaluation.evaluation.network.base.EvaluationNetwork
import com.evaluation.evaluation.util.Constants
import com.evaluation.evaluation.util.SharedPreferenceHelper
import com.google.gson.Gson
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Callback
import javax.inject.Inject

@ActivityRetainedScoped
class MyEvaluationRepository @Inject constructor(
    application: Application
) {

    fun getMyEvaluation(callback: Callback<BaseModel<List<EvaluationModel>>>) {
        val loadStr = SharedPreferenceHelper.loadStr(Constants.USER_INFO, "")
        val user = Gson().fromJson(loadStr, User::class.java)
        EvaluationNetwork.getMyEvaluation(user.id).enqueue(callback)
    }

}