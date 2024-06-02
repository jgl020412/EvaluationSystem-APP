package com.evaluation.evaluation.service

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.evaluation.evaluation.base.http
import com.evaluation.evaluation.model.model.ServiceListModel
import com.evaluation.evaluation.model.model.ServiceModel
import com.evaluation.evaluation.util.MLog
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ServiceViewModel @Inject constructor(
    application: Application,
    private val serviceRepository: ServiceRepository
) : AndroidViewModel(application) {

    private val serviceModel = MutableLiveData<List<ServiceModel>?>()

    val serviceList: LiveData<List<ServiceModel>?>
        get() = serviceModel

    fun getServiceList() {
        viewModelScope.http(
            request = { serviceRepository.getServiceList() },
            response = { success(it) },
            error = {
                Toast.makeText(getApplication(), it, Toast.LENGTH_SHORT).show()
            }
        )
    }

    private fun success(serviceList: List<ServiceModel>?) {
        serviceModel.postValue(serviceList)
    }

}