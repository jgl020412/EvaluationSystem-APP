package com.evaluation.evaluation.eval.my

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.evaluation.evaluation.model.model.BaseModel
import com.evaluation.evaluation.model.model.EvaluationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MyEvaluationViewModel @Inject constructor(
    application: Application,
    private val myEvaluationRepository: MyEvaluationRepository
) : AndroidViewModel(application) {

    private val myEvaluationModel = MutableLiveData<List<EvaluationModel>>()

    val evaluationList: LiveData<List<EvaluationModel>>
        get() = myEvaluationModel

    fun getMyEvaluation(block: () -> Unit) =
        myEvaluationRepository.getMyEvaluation(object : Callback<BaseModel<List<EvaluationModel>>> {
            override fun onResponse(
                call: Call<BaseModel<List<EvaluationModel>>>,
                response: Response<BaseModel<List<EvaluationModel>>>
            ) {
                response.body()?.let {
                    myEvaluationModel.value = it.data
                    block()
                }
            }

            override fun onFailure(call: Call<BaseModel<List<EvaluationModel>>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

}