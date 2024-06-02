package com.evaluation.evaluation.network.service

import com.evaluation.evaluation.model.model.BaseModel
import com.evaluation.evaluation.model.model.ServiceListModel
import com.evaluation.evaluation.model.model.ServiceModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ServService {

    @GET("/serviceMng/getServices")
    fun getServiceList(): Call<BaseModel<List<ServiceModel>>>

}