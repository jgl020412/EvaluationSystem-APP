package com.evaluation.evaluation.eval

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.graphics.drawable.LayerDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.evaluation.evaluation.App.Companion.context
import com.evaluation.evaluation.R
import com.evaluation.evaluation.database.pojo.Evaluation
import com.evaluation.evaluation.databinding.AdapterEvaluationBinding

class EvaluationAdapter(private val evaluationList: List<Evaluation>) :
    RecyclerView.Adapter<EvaluationAdapter.EvaluationHolder>() {
    inner class EvaluationHolder(val binding: AdapterEvaluationBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EvaluationHolder {
        val binding = AdapterEvaluationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EvaluationHolder(binding)
    }

    override fun getItemCount(): Int = evaluationList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: EvaluationHolder, position: Int) {
        val evaluation = evaluationList[position]
        holder.binding.evaluationTvUser.text = "用户${ evaluation.userId }"
        holder.binding.serviceTvTitle.text = evaluation.serviceId
        holder.binding.evaluationTvTime.text = evaluation.time
        holder.binding.ratingBar.rating = evaluation.level.toFloat()
        val star = holder.binding.ratingBar.progressDrawable as LayerDrawable
        star.getDrawable(2).setColorFilter(ContextCompat.getColor(context, R.color.fillStartColor), PorterDuff.Mode.SRC_ATOP)
        star.getDrawable(1).setColorFilter(ContextCompat.getColor(context, R.color.fillStartColor), PorterDuff.Mode.SRC_ATOP)
        star.getDrawable(0).setColorFilter(ContextCompat.getColor(context, R.color.emptyStarColor), PorterDuff.Mode.SRC_ATOP)
    }
}