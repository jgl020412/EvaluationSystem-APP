package com.evaluation.evaluation.profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.evaluation.evaluation.R
import com.evaluation.evaluation.base.ActivityCollector
import com.evaluation.evaluation.model.pojo.User
import com.evaluation.evaluation.databinding.FragmentUserBinding
import com.evaluation.evaluation.util.Constants
import com.evaluation.evaluation.util.SharedPreferenceHelper
import com.google.gson.Gson

class UserFragment: Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentUserBinding

    private var user = User(
        "123",
        "User",
        "123456",
        "18888888888",
        "1234567890@example.com",
        "288888888888888888",
        "程序员",
        1,
        "2024-50-20",
        "黑龙江",
        "哈尔滨",
        "依兰县",
        1
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        initView()
        initData()
        return binding.root
    }

    private fun initView() {
        binding.profileTitleBar.setTitle("个人信息")
        binding.profileTitleBar.setBackImageVisible(false)
        binding.profileUpdate.setOnClickListener(this)
        binding.profileBtnLogout.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    private fun initData() {
        user = Gson().fromJson(SharedPreferenceHelper.loadStr(Constants.USER_INFO, Gson().toJson(user)), User::class.java)
        binding.profileTvName.text = user.name
        binding.profileTvCity.text = "${ user.province }  ${ user.city }  ${ user.district }"
        binding.tvPhoneNum.text = user.phoneNum
        binding.tvSex.text = if (user.sex == 0) "女" else "男"
        binding.tvJob.text = user.job
        binding.tvEmail.text = user.mail
        binding.tvBirthday.text = user.birthday
        binding.tvIdNUm.text = user.idNum
    }

    companion object {
        fun newInstance() = UserFragment()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.profileUpdate -> {
            }
            R.id.profileBtnLogout -> {
                SharedPreferenceHelper.putBoolean(Constants.IS_LOGIN, false)
                ActivityCollector.finishAll()
            }
        }
    }

}