package com.evaluation.evaluation.main

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.evaluation.evaluation.R
import com.evaluation.evaluation.service.ServiceFragment

abstract class BaseMainBottomTabWidget(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), View.OnClickListener {

    private var mFragmentManager: FragmentManager? = null
    private var mFragments: ArrayList<Fragment> = arrayListOf()
    private var currentFragment: Fragment? = null

    /**
     * 外部调用初始化，传入必要的参数
     *
     * @param fm
     */
    fun init(fm: FragmentManager?) {
        mFragmentManager = fm
        if (mFragments.isEmpty()) {
            mFragments.apply {
                add(getCurrentFragment(0))
                add(getCurrentFragment(1))
                add(getCurrentFragment(2))
                add(getCurrentFragment(3))
            }
        }
        fragmentManger(0)
    }

    /**
     * 销毁，避免内存泄漏
     */
    open fun destroy() {
        mFragmentManager?.apply {
            if (!isDestroyed)
                mFragmentManager = null
        }
        if (mFragments.isNotEmpty()) {
            mFragments.clear()
        }
    }

    /**
     * fragment的切换 实现底部导航栏的切换
     *
     * @param position 序号
     */
    protected open fun fragmentManger(position: Int) {
        val targetFg: Fragment = mFragments[position]
        mFragmentManager?.beginTransaction()?.apply {
            currentFragment?.apply {
                hide(this)
            }
            setReorderingAllowed(true)
            if (!targetFg.isAdded) {
                add(R.id.mainFragment, targetFg).commit()
            } else {
                show(targetFg).commit()
            }
        }
        currentFragment = targetFg
    }

    private val serviceFragment: ServiceFragment by lazy { ServiceFragment.newInstance() }

    private fun getCurrentFragment(index: Int): Fragment {
        return when (index) {
            0 -> serviceFragment
            1 -> ServiceFragment()
            2 -> ServiceFragment()
            3 -> ServiceFragment()
            else -> serviceFragment
        }
    }

}