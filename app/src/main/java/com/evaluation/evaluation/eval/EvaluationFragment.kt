package com.evaluation.evaluation.eval

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.evaluation.evaluation.databinding.FragmentEvaluationBinding
import com.evaluation.evaluation.model.pojo.Evaluation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EvaluationFragment: Fragment() {

    private lateinit var binding: FragmentEvaluationBinding
    private val viewModel by viewModels<EvaluationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEvaluationBinding.inflate(inflater, container, false)
        viewModel.getAllEvaluation { initView() }
        return binding.root
    }

    private fun initView() {
        val evaluationAdapter = EvaluationAdapter(viewModel.evaluationList.value!!)
        val evaluationRecyclerView = binding.evaluationRecyclerView
        evaluationRecyclerView.adapter = evaluationAdapter
        evaluationRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.fragmentListBar.setBackImageVisible(false)
        binding.fragmentListBar.setTitle("所有评价")
    }

    companion object {
        fun newInstance() = EvaluationFragment()
    }

    private fun testInitEvaluationList(): List<Evaluation> {
        val evaluationList = ArrayList<Evaluation>()
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        evaluationList.add(Evaluation("id10", "这里应该存放服务的名字", "1000", "满分", 3, "2020-12-12"))
        return evaluationList
    }

}