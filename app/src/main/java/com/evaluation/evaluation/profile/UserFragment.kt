package com.evaluation.evaluation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.evaluation.evaluation.databinding.FragmentUserBinding

class UserFragment: Fragment() {

    private lateinit var binding: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        initView()
        return binding.root
    }

    private fun initView() {
        binding.profileTitleBar.setTitle("个人信息")
        binding.profileTitleBar.setBackImageVisible(false)
    }

    companion object {
        fun newInstance() = UserFragment()
    }

}