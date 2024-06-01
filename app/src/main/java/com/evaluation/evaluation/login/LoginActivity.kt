package com.evaluation.evaluation.login

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.activity.viewModels
import com.evaluation.evaluation.R
import com.evaluation.evaluation.base.BaseActivity
import com.evaluation.evaluation.databinding.ActivityLoginBinding
import com.evaluation.evaluation.main.MainActivity
import com.evaluation.evaluation.model.model.UserModel
import com.evaluation.evaluation.util.Constants
import com.evaluation.evaluation.util.SharedPreferenceHelper
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private var countDownTimer: CountDownTimer? = null
    private var timerDuration: Long = 60000 // 倒计时总时长，这里是60秒
    private val viewModel by viewModels<LoginViewModel>()
    private lateinit var phoneNum: String
    private lateinit var smsCode: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    fun initView() {
        binding.getSMSCode.setOnClickListener(this)
        binding.loginButton.setOnClickListener(this)
    }

    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        phoneNum = binding.loginUserNumberEdit.text.toString()
        smsCode = binding.loginVerificationEdit.text.toString()
        when (v?.id) {
            R.id.getSMSCode -> {
                binding.getSMSCode.isEnabled = false
                startCountDown()
                viewModel.getSMSCode(phoneNum)
            }

            R.id.loginButton -> {
                viewModel.isExit(phoneNum, smsCode)
                if (viewModel.user.value != null) {
                    if (viewModel.isRegister.value == true) {
                        SharedPreferenceHelper.putBoolean(Constants.IS_LOGIN, true)
                        SharedPreferenceHelper.putString(
                            Constants.USER_INFO,
                            Gson().toJson(viewModel.user.value)
                        )
                        MainActivity.actionStart(this)
                    } else {
                        RegisterActivity.actionStart(this, phoneNum, smsCode)
                    }
                    finish()
                }
            }
        }
    }

    private fun startCountDown() {
        countDownTimer?.cancel()
        countDownTimer = object : CountDownTimer(timerDuration, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                // 更新按钮显示剩余时间
                binding.getSMSCode.text = "${millisUntilFinished / 1000}s"
            }

            override fun onFinish() {
                // 倒计时结束，恢复按钮状态
                binding.getSMSCode.isEnabled = true
                binding.getSMSCode.text = "获取验证码"
            }
        }.start()
    }

}