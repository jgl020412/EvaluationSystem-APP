package com.evaluation.evaluation.profile.update

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.evaluation.evaluation.R
import com.evaluation.evaluation.base.BaseActivity
import com.evaluation.evaluation.databinding.ActivityUpdateUserInfoBinding
import com.evaluation.evaluation.main.MainActivity
import com.evaluation.evaluation.model.pojo.User
import com.evaluation.evaluation.util.Constants
import com.evaluation.evaluation.util.MLog
import com.evaluation.evaluation.util.SharedPreferenceHelper
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateUserInfoActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUpdateUserInfoBinding
    private val viewModel by viewModels<UpdateUserInfoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateUserInfoBinding.inflate(layoutInflater)
        initData()
        initView()
        setContentView(binding.root)
    }

    fun initData() {
        val userStr = SharedPreferenceHelper.loadStr(Constants.USER_INFO, "")
        viewModel.userModel.value = Gson().fromJson(userStr, User::class.java)
    }

    fun initView() {
        viewModel.userModel.value?.let {
            binding.nameEdit.setText(it.name)
            binding.mailEdit.setText(it.mail)
            binding.birthdayEdit.setText(it.birthday)
            binding.provinceEdit.setText(it.province)
            binding.cityEdit.setText(it.city)
            binding.districtEdit.setText(it.district)
            binding.jobEdit.setText(it.job)
            binding.sexEdit.setText(if (it.sex == 1) "男" else "女")
            binding.passwordEdit.setText(it.password)
        }
    }

    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, UpdateUserInfoActivity::class.java)
            context.startActivity(intent)
        }

        private const val TAG = "UpdateUserInfoActivity"
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.updateButton -> {
                MLog.d(TAG, "update info ... ")
                viewModel.userModel.value?.let {
                    it.name = binding.nameEdit.text.toString()
                    it.mail = binding.mailEdit.text.toString()
                    it.birthday = binding.birthdayEdit.text.toString()
                    it.province = binding.provinceEdit.text.toString()
                    it.city = binding.cityEdit.text.toString()
                    it.district = binding.districtEdit.text.toString()
                    it.job = binding.jobEdit.text.toString()
                    it.sex = if (binding.sexEdit.text.toString() == "男") 1 else 0
                    it.password = binding.passwordEdit.text.toString()
                }
                viewModel.updateUserInfo()
                finish()
            }
        }
    }

}