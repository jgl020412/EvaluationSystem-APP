package com.evaluation.evaluation.eval.reply.my

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.evaluation.evaluation.App
import com.evaluation.evaluation.model.model.BaseModel
import com.evaluation.evaluation.model.model.EvaluationModel
import com.evaluation.evaluation.model.model.ReplyModel
import com.google.gson.annotations.Until
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MyReplyViewModel @Inject constructor(
    application: Application,
    private val myReplyRepository: MyReplyRepository
): AndroidViewModel(application) {
    val evaluationModel = MutableLiveData<EvaluationModel>()

    private val replyModel = MutableLiveData<List<ReplyModel>>()

    val replyList: LiveData<List<ReplyModel>>
        get() = replyModel

    val content = MutableLiveData<String>()

    fun createReply() {
        myReplyRepository.createReply(content.value!!, evaluationModel.value?.id!!, object : Callback<BaseModel<Int>>{
            override fun onResponse(
                call: Call<BaseModel<Int>>,
                response: Response<BaseModel<Int>>
            ) {
                Toast.makeText(App.context, "回复成功", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<BaseModel<Int>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getReplyList(block: () -> Unit) {
        myReplyRepository.getReplies(evaluationModel.value?.id!!, object : Callback<BaseModel<List<ReplyModel>>>{
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