package com.evaluation.evaluation.eval.reply.my

import android.app.Application
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class MyReplyRepository @Inject constructor(
    application: Application
) {
}