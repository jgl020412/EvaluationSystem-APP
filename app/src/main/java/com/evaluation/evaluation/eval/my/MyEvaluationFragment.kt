package com.evaluation.evaluation.eval.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.evaluation.evaluation.model.pojo.Evaluation
import com.evaluation.evaluation.databinding.FragmentEvaluationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyEvaluationFragment: Fragment() {

    private lateinit var binding: FragmentEvaluationBinding
    private val viewModel by viewModels<MyEvaluationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEvaluationBinding.inflate(inflater, container, false)
        viewModel.getMyEvaluation { initView() }
        return binding.root
    }

    private fun initView() {
        val evaluationAdapter = MyEvaluationAdapter(viewModel.evaluationList.value!!)
        val evaluationRecyclerView = binding.evaluationRecyclerView
        evaluationRecyclerView.adapter = evaluationAdapter
        evaluationRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.fragmentListBar.setBackImageVisible(false)
        binding.fragmentListBar.setTitle("我的评价")
    }

    companion object {
        fun newInstance() = MyEvaluationFragment()
    }

}