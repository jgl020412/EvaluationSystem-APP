package com.evaluation.evaluation.eval

import android.app.Application
import com.evaluation.evaluation.model.model.BaseModel
import com.evaluation.evaluation.model.model.EvaluationModel
import com.evaluation.evaluation.network.base.EvaluationNetwork
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Callback
import javax.inject.Inject

@ActivityRetainedScoped
class EvaluationRepository @Inject constructor(application: Application) {

    fun getEvaluations(callback: Callback<BaseModel<List<EvaluationModel>>>) =
        EvaluationNetwork.getAllEvaluation().enqueue(callback)

}