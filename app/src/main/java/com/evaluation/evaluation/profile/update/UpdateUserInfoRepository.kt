package com.evaluation.evaluation.profile.update

import android.app.Application
import android.widget.Toast
import com.evaluation.evaluation.App
import com.evaluation.evaluation.model.model.BaseModel
import com.evaluation.evaluation.model.pojo.User
import com.evaluation.evaluation.network.base.EvaluationNetwork
import com.evaluation.evaluation.util.Constants
import com.evaluation.evaluation.util.SharedPreferenceHelper
import com.google.gson.Gson
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@ActivityRetainedScoped
class UpdateUserInfoRepository @Inject constructor(
    application: Application
) {

    fun updateUserInfo(user: User) {
        EvaluationNetwork.updateUserInfo(user).enqueue(object : Callback<BaseModel<Int>>{
            override fun onResponse(
                call: Call<BaseModel<Int>>,
                response: Response<BaseModel<Int>>
            ) {
                SharedPreferenceHelper.putString(Constants.USER_INFO, Gson().toJson(user))
                Toast.makeText(App.context, "修改成功", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<BaseModel<Int>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}