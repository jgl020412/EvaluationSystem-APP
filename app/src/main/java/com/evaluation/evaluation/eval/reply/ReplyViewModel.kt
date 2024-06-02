package com.evaluation.evaluation.eval.reply

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.evaluation.evaluation.model.model.BaseModel
import com.evaluation.evaluation.model.model.EvaluationModel
import com.evaluation.evaluation.model.model.ReplyModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ReplyViewModel @Inject constructor(
    application: Application,
    private val replyRepository: ReplyRepository
): AndroidViewModel(application) {

    val evaluationModel = MutableLiveData<EvaluationModel>()

    private val replyModel = MutableLiveData<List<ReplyModel>>()

    val replyList: LiveData<List<ReplyModel>>
        get() = replyModel

    fun getReplyList(block: () -> Unit) {
        replyRepository.getReplies(evaluationModel.value?.id!!, object :
            Callback<BaseModel<List<ReplyModel>>> {
            override fun onResponse(
                call: Call<BaseModel<List<ReplyModel>>>,
                response: Response<BaseModel<List<ReplyModel>>>
            ) {
                response.body()?.let {
                    replyModel.value = it.data
                    block()
                }
            }

            override fun onFailure(call: Call<BaseModel<List<ReplyModel>>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}