package com.evaluation.evaluation.eval

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.evaluation.evaluation.model.model.BaseModel
import com.evaluation.evaluation.model.model.EvaluationModel
import com.evaluation.evaluation.util.MLog
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class EvaluationViewModel @Inject constructor(
    application: Application,
    private val evaluationRepository: EvaluationRepository
) : AndroidViewModel(application) {

    private val evaluationModel = MutableLiveData<List<EvaluationModel>>()

    val evaluationList: LiveData<List<EvaluationModel>>
        get() = evaluationModel

    fun getAllEvaluation(block: () -> Unit) {
        evaluationRepository.getEvaluations(object : Callback<BaseModel<List<EvaluationModel>>> {
            override fun onResponse(
                call: Call<BaseModel<List<EvaluationModel>>>,
                response: Response<BaseModel<List<EvaluationModel>>>
            ) {
                response.body()?.let {
                    evaluationModel.value = it.data
                    block()
                }
            }

            override fun onFailure(call: Call<BaseModel<List<EvaluationModel>>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}