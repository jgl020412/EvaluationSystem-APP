package com.evaluation.evaluation.service

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.evaluation.evaluation.model.model.BaseModel
import com.evaluation.evaluation.model.model.ServiceModel
import com.evaluation.evaluation.util.MLog
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ServiceViewModel @Inject constructor(
    application: Application,
    private val serviceRepository: ServiceRepository
) : AndroidViewModel(application) {

    private val serviceModel = MutableLiveData<List<ServiceModel>?>()

    val serviceList: LiveData<List<ServiceModel>?>
        get() = serviceModel

    fun getServiceList(block: () -> Unit) {
        serviceRepository.getServiceList(object : Callback<BaseModel<List<ServiceModel>>> {
            override fun onResponse(
                call: Call<BaseModel<List<ServiceModel>>>,
                response: Response<BaseModel<List<ServiceModel>>>
            ) {
                response.body()?.let {
                    serviceModel.value = it.data
                    MLog.d(TAG, "${it.data}")
                    block()
                }
            }

            override fun onFailure(call: Call<BaseModel<List<ServiceModel>>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    companion object {
        private const val TAG = "ServiceViewModel"
    }
}