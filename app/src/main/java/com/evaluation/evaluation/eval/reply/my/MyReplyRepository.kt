package com.evaluation.evaluation.eval.reply.my

import android.app.Application
import com.evaluation.evaluation.model.model.BaseModel
import com.evaluation.evaluation.model.model.ReplyModel
import com.evaluation.evaluation.model.pojo.NewReplyBO
import com.evaluation.evaluation.model.pojo.User
import com.evaluation.evaluation.network.base.EvaluationNetwork
import com.evaluation.evaluation.util.Constants
import com.evaluation.evaluation.util.SharedPreferenceHelper
import com.google.gson.Gson
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Callback
import javax.inject.Inject

@ActivityRetainedScoped
class MyReplyRepository @Inject constructor(
    application: Application
) {

    fun getReplies(evaluationId: String, callback: Callback<BaseModel<List<ReplyModel>>>) {
        EvaluationNetwork.getReplies(evaluationId).enqueue(callback)
    }

    fun createReply(content: String, evaluationId: String, callback: Callback<BaseModel<Int>>) {
        val str = SharedPreferenceHelper.loadStr(Constants.USER_INFO, "")
        val user = Gson().fromJson(str, User::class.java)
        EvaluationNetwork.createReply(
            NewReplyBO(content, evaluationId, "", "0", user.id)
        ).enqueue(callback)
    }

}