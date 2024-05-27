package com.evaluation.evaluation.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.evaluation.evaluation.base.BaseActivity
import com.evaluation.evaluation.databinding.ActivityRegisterBinding

class RegisterActivity : BaseActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, RegisterActivity::class.java)
            context.startActivity(intent)
        }
    }

}