package com.evaluation.evaluation.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application,
    private val loginActivity: LoginActivity
) : AndroidViewModel(application) {
    // TODO 接入登录数据
}