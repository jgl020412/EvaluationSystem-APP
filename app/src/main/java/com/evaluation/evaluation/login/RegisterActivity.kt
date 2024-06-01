package com.evaluation.evaluation.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.evaluation.evaluation.R
import com.evaluation.evaluation.base.BaseActivity
import com.evaluation.evaluation.databinding.ActivityRegisterBinding
import com.evaluation.evaluation.main.MainActivity
import com.evaluation.evaluation.model.pojo.UserBO
import com.evaluation.evaluation.util.Constants
import com.evaluation.evaluation.util.SharedPreferenceHelper
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRegisterBinding

    private val viewModel by viewModels<RegisterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        binding.loginButton.setOnClickListener(this)
        setContentView(binding.root)
    }


    companion object {

        private lateinit var mobile: String
        private lateinit var smsCode: String

        fun actionStart(context: Context, mobile: String, smsCode: String) {
            this.mobile = mobile
            this.smsCode = smsCode
            val intent = Intent(context, RegisterActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.loginButton -> {
                viewModel.userContent.postValue(
                    UserBO(
                        binding.nameEdit.text.toString(),
                        binding.passwordEdit.text.toString(),
                        mobile,
                        binding.mailEdit.text.toString(),
                        binding.idNumEdit.text.toString(),
                        binding.jobEdit.text.toString(),
                        if (binding.sexEdit.text.toString() == "男") 1 else 0,
                        binding.birthdayEdit.text.toString(),
                        binding.provinceEdit.text.toString(),
                        binding.cityEdit.text.toString(),
                        binding.districtEdit.text.toString(),
                        1,
                        smsCode,
                    )
                )
                viewModel.register()
                if (viewModel.user.value?.id != null) {
                    MainActivity.actionStart(this)
                    SharedPreferenceHelper.putString(
                        Constants.USER_INFO,
                        Gson().toJson(viewModel.user.value)
                    )
                    SharedPreferenceHelper.putBoolean(Constants.IS_LOGIN, true)
                } else {
                    Toast.makeText(this, "创建失败", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}