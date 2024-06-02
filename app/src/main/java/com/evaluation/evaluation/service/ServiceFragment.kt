package com.evaluation.evaluation.service

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.evaluation.evaluation.databinding.FragmentServiceBinding
import com.evaluation.evaluation.model.entity.Service
import com.evaluation.evaluation.model.model.ServiceModel
import com.evaluation.evaluation.util.MLog
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ServiceFragment : Fragment() {

    private lateinit var binding: FragmentServiceBinding
    private val viewModel by viewModels<ServiceViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentServiceBinding.inflate(inflater, container, false)
        val handler: Handler = Handler(Looper.getMainLooper())

        viewModel.getServiceList()

        initView()
        return binding.root
    }

    private fun initView() {
        var serviceAdapter: ServiceAdapter
        if (viewModel.serviceList.value != null) {
            serviceAdapter = ServiceAdapter(viewModel.serviceList.value!!)
        } else {
            serviceAdapter = ServiceAdapter(testInitService())
        }
        binding.serviceRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.serviceRecyclerView.adapter = serviceAdapter
        binding.serviceListBar.setBackImageVisible(false)
        binding.serviceListBar.setRightImage(true)
        binding.serviceListBar.setTitle("服务")
    }

    companion object {
        fun newInstance() = ServiceFragment()
        private const val TAG = "ServiceFragment"
    }

    private fun testInitService(): List<ServiceModel> {
        val serviceList = ArrayList<ServiceModel>()
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        serviceList.add(ServiceModel("1001", "服务名字仅仅是测试", "部门名字测试用", "暂时没有详细内容"))
        return serviceList
    }

}