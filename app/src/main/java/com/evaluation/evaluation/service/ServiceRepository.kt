package com.evaluation.evaluation.service

import android.app.Application
import com.evaluation.evaluation.model.model.BaseModel
import com.evaluation.evaluation.model.model.ServiceModel
import com.evaluation.evaluation.network.base.EvaluationNetwork
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Callback
import javax.inject.Inject

@ActivityRetainedScoped
class ServiceRepository @Inject constructor(val application: Application) {

    fun getServiceList(callback: Callback<BaseModel<List<ServiceModel>>>) =
        EvaluationNetwork.getServices().enqueue(callback)

}