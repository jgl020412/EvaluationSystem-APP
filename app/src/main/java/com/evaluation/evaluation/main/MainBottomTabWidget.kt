package com.evaluation.evaluation.main

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.evaluation.evaluation.R
import com.evaluation.evaluation.databinding.LayoutBottomTabBinding

class MainBottomTabWidget @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseMainBottomTabWidget(context, attrs, defStyleAttr),
    View.OnClickListener {

    private var textViews: ArrayList<TextView> = arrayListOf()

    /**
     * 初始化 设置点击事件。
     *
     */
    init { //默认第一个碎片
        val view = LayoutBottomTabBinding.inflate(LayoutInflater.from(context), this, true)
        view.apply {
            textViews = arrayListOf(serviceAtMain, allAtMain, myAtMain, mineAtMain)
        }
        for (textView in textViews) {
            textView.setOnClickListener(this)
        }
    }

    /**
     * 销毁，避免内存泄漏
     */
    override fun destroy() {
        super.destroy()
        if (textViews.isNotEmpty()) {
            textViews.clear()
        }
    }

    /**
     * 实现按钮的点击事件
     */
    override fun onClick(v: View) {
        when (v.id) {
            R.id.serviceAtMain -> fragmentManger(0)
            R.id.allAtMain -> fragmentManger(1)
            R.id.myAtMain -> fragmentManger(2)
            R.id.mineAtMain -> fragmentManger(3)
        }
    }

    /**
     * fragment的切换 实现底部导航栏的切换
     *
     * @param position 序号
     */
    override fun fragmentManger(position: Int) {
        super.fragmentManger(position)
        for (j in textViews.indices) {
            textViews[j].isSelected = position == j
        }
    }

}