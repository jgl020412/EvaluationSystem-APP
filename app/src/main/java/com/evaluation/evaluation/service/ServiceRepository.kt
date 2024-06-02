package com.evaluation.evaluation.service

import android.app.Application
import com.evaluation.evaluation.model.model.BaseModel
import com.evaluation.evaluation.model.model.ServiceListModel
import com.evaluation.evaluation.model.model.ServiceModel
import com.evaluation.evaluation.network.base.EvaluationNetwork
import com.evaluation.evaluation.util.MLog
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class ServiceRepository @Inject constructor(val application: Application) {

    suspend fun getServiceList() = EvaluationNetwork.getServices()

}