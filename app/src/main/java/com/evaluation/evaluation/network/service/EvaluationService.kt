package com.evaluation.evaluation.network.service

import com.evaluation.evaluation.model.model.BaseModel
import com.evaluation.evaluation.model.model.EvaluationModel
import com.evaluation.evaluation.model.model.ReplyModel
import com.evaluation.evaluation.model.pojo.EvaluationBO
import com.evaluation.evaluation.model.pojo.NewReplyBO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface EvaluationService {

    @GET("/evaluation/queryAllEvaluation")
    fun getAllEvaluation() : Call<BaseModel<List<EvaluationModel>>>

    @GET("/evaluation/queryEvaluationOfUser")
    fun getMyEvaluation(@Query("userId") userId: String) : Call<BaseModel<List<EvaluationModel>>>

    @POST("/evaluation/createEvaluation")
    fun createEvaluation(@Body evaluationBO: EvaluationBO): Call<BaseModel<Int>>

    @GET("/reply/getReplies")
    fun getReplies(@Query("evaluationId") evaluationId: String): Call<BaseModel<List<ReplyModel>>>

    @POST("/reply/createReply")
    fun createReply(@Body newReplyBO: NewReplyBO): Call<BaseModel<Int>>

}