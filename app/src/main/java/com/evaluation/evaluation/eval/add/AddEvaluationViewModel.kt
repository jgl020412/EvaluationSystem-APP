package com.evaluation.evaluation.eval.add

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.evaluation.evaluation.model.model.BaseModel
import com.evaluation.evaluation.model.model.ServiceModel
import com.evaluation.evaluation.model.pojo.EvaluationBO
import com.evaluation.evaluation.model.pojo.User
import com.evaluation.evaluation.util.Constants
import com.evaluation.evaluation.util.SharedPreferenceHelper
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AddEvaluationViewModel @Inject constructor(
    application: Application,
    private val addEvaluationRepository: AddEvaluationRepository
) : AndroidViewModel(application){

    val serviceModel = MutableLiveData<ServiceModel>()

    fun createEvaluation(content: String, level: Int) {
        val userStr = SharedPreferenceHelper.loadStr(Constants.USER_INFO, "")
        val user = Gson().fromJson(userStr, User::class.java)
        val evaluationBO = EvaluationBO(
            content,
            level,
            serviceModel.value!!.id,
            user.id,
        )
        addEvaluationRepository.createEvaluation(evaluationBO, object : Callback<BaseModel<Int>>{
            override fun onResponse(
                call: Call<BaseModel<Int>>,
                response: Response<BaseModel<Int>>
            ) {
                Toast.makeText(getApplication(), "提交成功", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<BaseModel<Int>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}