package com.evaluation.evaluation.login

import android.app.Application
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class LoginRepository @Inject constructor(val application: Application) {
}