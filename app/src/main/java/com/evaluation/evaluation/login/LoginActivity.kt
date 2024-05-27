package com.evaluation.evaluation.login

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.evaluation.evaluation.R
import com.evaluation.evaluation.base.BaseActivity
import com.evaluation.evaluation.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private var countDownTimer: CountDownTimer? = null
    private var timerDuration: Long = 60000 // 倒计时总时长，这里是60秒
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
        when (v?.id) {
            R.id.getSMSCode -> {
                binding.getSMSCode.isEnabled = false
                startCountDown()
            }

            R.id.loginButton -> {}
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