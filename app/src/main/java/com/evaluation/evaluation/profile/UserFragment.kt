package com.evaluation.evaluation.profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.evaluation.evaluation.database.pojo.User
import com.evaluation.evaluation.databinding.FragmentUserBinding

class UserFragment: Fragment() {

    private lateinit var binding: FragmentUserBinding

    private val user = User(
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
    }

    @SuppressLint("SetTextI18n")
    private fun initData() {
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

}