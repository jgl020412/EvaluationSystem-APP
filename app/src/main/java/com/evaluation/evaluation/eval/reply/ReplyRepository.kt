package com.evaluation.evaluation.eval.reply

import android.app.Application
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class ReplyRepository @Inject constructor(
    application: Application
){
}