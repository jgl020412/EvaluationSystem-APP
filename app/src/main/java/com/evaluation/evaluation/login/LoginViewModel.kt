package com.evaluation.evaluation.login

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.evaluation.evaluation.base.http
import com.evaluation.evaluation.model.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application,
    private val loginRepository: LoginRepository
) : AndroidViewModel(application) {
    private val userState = MutableLiveData<UserModel?>()
    val user: LiveData<UserModel?>
        get() = userState

    private val _isRegister = MutableLiveData<Boolean>()
    val isRegister: LiveData<Boolean>
        get() = _isRegister

    fun getSMSCode(mobile: String) {
        viewModelScope.http(
            request = {loginRepository.getSMSCode(mobile)},
            response = {success(it)}
        )
    }

    fun isExit(mobile: String, smsCode: String) {
        viewModelScope.http(
            request = {loginRepository.isExit(mobile, smsCode)},
            response = {saveState(it)},
            error = {Toast.makeText(getApplication(), it, Toast.LENGTH_SHORT).show()}
        )
    }

    private fun success(nullInt: Int?) {
        Toast.makeText(getApplication(), "发送成功", Toast.LENGTH_SHORT).show()
    }

    private fun saveState(userModel: UserModel?) {
        userState.postValue(userModel)
        if (userModel?.id != null) {
            _isRegister.postValue(true)
        } else {
            _isRegister.postValue(false)
        }
    }
}