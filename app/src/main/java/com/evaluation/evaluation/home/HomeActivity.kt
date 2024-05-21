package com.evaluation.evaluation.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.evaluation.evaluation.base.BaseActivity
import com.evaluation.evaluation.databinding.ActivityHomeBinding

class HomeActivity: BaseActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }
    }

}