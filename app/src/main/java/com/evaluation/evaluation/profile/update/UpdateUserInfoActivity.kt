package com.evaluation.evaluation.profile.update

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.evaluation.evaluation.R
import com.evaluation.evaluation.base.BaseActivity
import com.evaluation.evaluation.databinding.ActivityUpdateUserInfoBinding

class UpdateUserInfoActivity : BaseActivity() {

    private lateinit var binding: ActivityUpdateUserInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, UpdateUserInfoActivity::class.java)
            context.startActivity(intent)
        }
    }

}