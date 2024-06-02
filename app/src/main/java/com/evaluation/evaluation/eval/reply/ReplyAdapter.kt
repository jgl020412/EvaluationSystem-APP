package com.evaluation.evaluation.eval.reply

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evaluation.evaluation.databinding.AdapterReplyBinding
import com.evaluation.evaluation.model.model.ReplyModel

class ReplyAdapter(private val replyList: List<ReplyModel>) :
    RecyclerView.Adapter<ReplyAdapter.ReplyHolder>() {
    inner class ReplyHolder(val binding: AdapterReplyBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReplyHolder {
        val binding =
            AdapterReplyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = ReplyHolder(binding)
        return holder
    }

    override fun getItemCount() = replyList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ReplyHolder, position: Int) {
        val reply = replyList[position]
        holder.binding.replyContent.text = reply.content
        holder.binding.replyTvTime.text = reply.time
        holder.binding.replyTvUser.text = "用户${reply.userId}"
    }
}