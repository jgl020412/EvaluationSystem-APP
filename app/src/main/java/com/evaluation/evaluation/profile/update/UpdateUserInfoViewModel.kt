package com.evaluation.evaluation.profile.update

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.evaluation.evaluation.model.pojo.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UpdateUserInfoViewModel @Inject constructor(
    application: Application,
    private val updateUserInfoRepository: UpdateUserInfoRepository
) : AndroidViewModel(application) {

    val userModel = MutableLiveData<User>()

    fun updateUserInfo() = updateUserInfoRepository.updateUserInfo(userModel.value!!)

}