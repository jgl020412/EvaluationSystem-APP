package com.evaluation.evaluation.service

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.evaluation.evaluation.R
import com.evaluation.evaluation.model.entity.Service
import com.evaluation.evaluation.model.model.ServiceModel

class ServiceAdapter(val serviceList: List<ServiceModel>) :
    RecyclerView.Adapter<ServiceAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val serviceName: TextView = view.findViewById(R.id.adapter_service_name_tv)
        val department: TextView = view.findViewById(R.id.adapter_service_department_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_service, parent, false)
        val viewHolder = ViewHolder(view)
        view.setOnClickListener {
            val index = viewHolder.adapterPosition
            AlertDialog.Builder(view.context).apply {
                setTitle(serviceList[index].name)
                setMessage(serviceList[index].details)
                show()
            }
        }
        return viewHolder
    }

    override fun getItemCount(): Int = serviceList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val service = serviceList[position]
        holder.serviceName.text = service.name
        holder.department.text = service.department
    }

}