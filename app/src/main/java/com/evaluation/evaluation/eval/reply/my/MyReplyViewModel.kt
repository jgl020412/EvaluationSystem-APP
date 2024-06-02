package com.evaluation.evaluation.eval.reply.my

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.evaluation.evaluation.model.model.EvaluationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyReplyViewModel @Inject constructor(
    application: Application,
    private val myReplyRepository: MyReplyRepository
): AndroidViewModel(application) {
    val evaluationModel = MutableLiveData<EvaluationModel>()
}