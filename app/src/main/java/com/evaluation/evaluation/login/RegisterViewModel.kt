package com.evaluation.evaluation.login

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.evaluation.evaluation.base.http
import com.evaluation.evaluation.model.model.UserModel
import com.evaluation.evaluation.model.pojo.User
import com.evaluation.evaluation.model.pojo.UserBO
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    application: Application,
    private val registerRepository: RegisterRepository
) : AndroidViewModel(application) {

    val userContent = MutableLiveData<UserBO>()

    private val userModel = MutableLiveData<UserModel>()

    val user: LiveData<UserModel>
        get() = userModel

    fun register() {
        viewModelScope.http(
            request = { registerRepository.doRegister(userContent.value!!) },
            response = { success(it) },
            error = { Toast.makeText(getApplication(), it, Toast.LENGTH_SHORT).show() }
        )
    }

    fun success(it: UserModel?) {
        userModel.postValue(it)
    }
}