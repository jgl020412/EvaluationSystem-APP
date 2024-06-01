package com.evaluation.evaluation.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.evaluation.evaluation.base.BaseActivity
import com.evaluation.evaluation.databinding.ActivityMainBinding
import com.evaluation.evaluation.model.model.UserModel
import com.evaluation.evaluation.model.pojo.User

class MainActivity: BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.mainView.init(supportFragmentManager)
        setContentView(binding.root)
    }

    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

}