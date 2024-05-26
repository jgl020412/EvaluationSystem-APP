package com.evaluation.evaluation

import android.os.Bundle
import android.view.View
import com.evaluation.evaluation.base.BaseActivity
import com.evaluation.evaluation.databinding.ActivityWelcomeBinding
import com.evaluation.evaluation.main.MainActivity
import com.evaluation.evaluation.login.LoginActivity
import com.evaluation.evaluation.util.Constants
import com.evaluation.evaluation.util.SharedPreferenceHelper

class WelcomeActivity : BaseActivity() {

    private lateinit var binding: ActivityWelcomeBinding
    private var isLogin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
        jump()
    }

    fun initData() {
        isLogin = SharedPreferenceHelper.loadBoolean(Constants.IS_LOGIN, false)
    }

    fun jump() {
        Thread {
            Thread.sleep(2000)
            if (isLogin) {
                MainActivity.actionStart(this)
            } else {
                LoginActivity.actionStart(this)
            }
            finish()
        }.start()
        finish()
    }

}