package com.evaluation.evaluation.eval.reply.my

import android.app.Application
import com.evaluation.evaluation.model.model.BaseModel
import com.evaluation.evaluation.model.model.ReplyModel
import com.evaluation.evaluation.network.base.EvaluationNetwork
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Callback
import javax.inject.Inject

@ActivityRetainedScoped
class MyReplyRepository @Inject constructor(
    application: Application
) {

    fun getReplies(evaluationId : String, callback: Callback<BaseModel<List<ReplyModel>>>) {
        EvaluationNetwork.getReplies(evaluationId).enqueue(callback)
    }

}