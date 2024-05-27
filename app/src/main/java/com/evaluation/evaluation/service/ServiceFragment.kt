package com.evaluation.evaluation.service

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.evaluation.evaluation.model.entity.Service
import com.evaluation.evaluation.databinding.FragmentServiceBinding

class ServiceFragment: Fragment() {

    private lateinit var binding: FragmentServiceBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentServiceBinding.inflate(inflater, container, false)
        initView()
        return binding.root
    }

    private fun initView() {
        val serviceAdapter = ServiceAdapter(testInitService())
        binding.serviceRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.serviceRecyclerView.adapter = serviceAdapter
        binding.serviceListBar.setBackImageVisible(false)
        binding.serviceListBar.setRightImage(true)
        binding.serviceListBar.setTitle("服务")
    }

    companion object {
        fun newInstance() = ServiceFragment()
    }

    private fun testInitService() : List<Service>{
        val serviceList = ArrayList<Service>()
        serviceList.add(Service("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(Service("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(Service("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(Service("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(Service("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(Service("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(Service("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(Service("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(Service("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(Service("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(Service("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(Service("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(Service("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(Service("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(Service("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        return serviceList
    }

}