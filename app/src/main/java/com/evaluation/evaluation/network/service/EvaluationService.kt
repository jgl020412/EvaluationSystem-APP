package com.evaluation.evaluation.network.service

import com.evaluation.evaluation.model.model.BaseModel
import com.evaluation.evaluation.model.model.EvaluationModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EvaluationService {

    @GET("/evaluation/queryAllEvaluation")
    fun getAllEvaluation() : Call<BaseModel<List<EvaluationModel>>>

    @GET("/evaluation/queryEvaluationOfUser")
    fun getMyEvaluation(@Query("userId") userId: String) : Call<BaseModel<List<EvaluationModel>>>

}