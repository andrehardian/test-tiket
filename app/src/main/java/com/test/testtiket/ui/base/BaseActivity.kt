package com.github.apps.ui.base

import android.annotation.TargetApi
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.test.testtiket.ui.base.BaseViewModel
import dagger.android.AndroidInjection

abstract class BaseActivity<T : ViewDataBinding?, V : BaseViewModel<*, *>?> : AppCompatActivity(){
    var viewDataBinding: T? = null
        private set
    private var mViewModel: V? = null
    abstract val bindingVariable: Int

    @get:LayoutRes
    abstract val layoutId: Int

    abstract val viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String?): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission!!) == PackageManager.PERMISSION_GRANTED
    }

    fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView<T>(this, layoutId)
        mViewModel = if (mViewModel == null) viewModel else mViewModel
        viewDataBinding!!.setVariable(bindingVariable, mViewModel)
        viewDataBinding!!.executePendingBindings()
    }
}