package com.evaluation.evaluation.eval.add

import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.evaluation.evaluation.App
import com.evaluation.evaluation.R
import com.evaluation.evaluation.base.BaseActivity
import com.evaluation.evaluation.databinding.ActivityAddEvaluationBinding
import com.evaluation.evaluation.model.model.ServiceModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddEvaluationActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAddEvaluationBinding

    private val viewModel by viewModels<AddEvaluationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEvaluationBinding.inflate(layoutInflater)
        initData()
        initView()
        setContentView(binding.root)
    }

    fun initData() {
        val service = Gson().fromJson(intent.getStringExtra("service"), ServiceModel::class.java)
        viewModel.serviceModel.value = service
    }

    fun initView() {

        binding.title.text = viewModel.serviceModel.value?.name
        binding.details.text = viewModel.serviceModel.value?.details

        binding.commitButton.setOnClickListener(this)

        val star = binding.ratingBar.progressDrawable as LayerDrawable
        star.getDrawable(2).setColorFilter(ContextCompat.getColor(App.context, R.color.fillStartColor), PorterDuff.Mode.SRC_ATOP)
        star.getDrawable(1).setColorFilter(ContextCompat.getColor(App.context, R.color.fillStartColor), PorterDuff.Mode.SRC_ATOP)
        star.getDrawable(0).setColorFilter(ContextCompat.getColor(App.context, R.color.emptyStarColor), PorterDuff.Mode.SRC_ATOP)
    }

    companion object {
        fun actionStart(context: Context, serviceModel: ServiceModel) {
            val intent = Intent(context, AddEvaluationActivity::class.java)
            intent.putExtra("service", Gson().toJson(serviceModel))
            context.startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.commitButton -> {
                val content = binding.evaluationEdit.text.toString()
                val level = binding.ratingBar.numStars
                viewModel.createEvaluation(content, level)
                finish()
            }
        }
    }

}