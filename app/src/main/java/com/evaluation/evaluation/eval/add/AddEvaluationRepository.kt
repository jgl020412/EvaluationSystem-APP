package com.evaluation.evaluation.eval.add

import android.app.Application
import com.evaluation.evaluation.model.model.BaseModel
import com.evaluation.evaluation.model.pojo.EvaluationBO
import com.evaluation.evaluation.network.base.EvaluationNetwork
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Callback
import javax.inject.Inject

@ActivityRetainedScoped
class AddEvaluationRepository @Inject constructor(
    application: Application
) {

    fun createEvaluation(evaluationBO: EvaluationBO, callback: Callback<BaseModel<Int>>) {
        EvaluationNetwork.createEvaluation(evaluationBO).enqueue(callback)
    }

}