package com.evaluation.evaluation.main

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.isVisible
import com.evaluation.evaluation.R
import com.evaluation.evaluation.databinding.LayoutTitleBinding
import com.evaluation.evaluation.util.hideIme

class TitleBar @JvmOverloads constructor(
    private val mContext: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(mContext, attrs, defStyleAttr), View.OnClickListener {

    private var mTitleTv: TextView
    private var mImgBack: ImageView
    private var mImgRight: ImageView
    private var titleName: String = ""
    private var backImageVisible: Boolean = false

    /**
     * 初始化布局
     */
    init {
        //加载布局
        View.inflate(mContext, R.layout.layout_title, this)
        val binding = LayoutTitleBinding.inflate(LayoutInflater.from(context), this, true)
        binding.apply {
            //控制头布局，返回关闭页面
            mImgBack = imgBack
            //控制标题
            mTitleTv = txtTitle
            //右边图片
            mImgRight = imgRight
        }
        mImgBack.setOnClickListener(this)
        mTitleTv.text = titleName ?: ""
        setBackImageVisible(backImageVisible ?: true)
    }

    /**
     * 设置标题栏标题
     *
     * @param title 标题
     */
    fun setTitle(title: String?) {
        mTitleTv.text = title
    }

    /**
     * 设置返回按钮图片
     *
     * @param imageId 图片id
     */
    fun setBackImage(imageId: Int) {
        if (imageId != 0) {
            mImgBack.setImageResource(imageId)
        }
    }

    /**
     * 设置返回按钮图片是否显示
     *
     * @param imageVisible 是否显示
     */
    fun setBackImageVisible(imageVisible: Boolean) {
        mImgBack.isVisible = imageVisible
    }

    /**
     * 显示搜索键
     *
     * @param imageId 图片id
     */
    fun setRightImage(isVisible: Boolean) {
        if (isVisible) {
            mImgRight.visibility = View.VISIBLE
        } else {
            mImgRight.visibility = View.GONE
        }
    }


    override fun onClick(v: View) {
        if (v.id == R.id.imgBack) {
            //关闭页面
            (mContext as Activity).hideIme()
            mContext.finish()
        }
    }

    fun setRightImgOnClickListener(onClickListener: OnClickListener) {
        mImgRight.setOnClickListener(onClickListener)
    }

    fun setTitleOnClickListener(onClickListener: OnClickListener) {
        mTitleTv.setOnClickListener(onClickListener)
    }

}