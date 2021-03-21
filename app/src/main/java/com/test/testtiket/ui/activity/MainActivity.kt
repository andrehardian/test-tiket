package com.test.testtiket.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.apps.ui.base.BaseActivity
import com.test.testtiket.BR
import com.test.testtiket.R
import com.test.testtiket.ViewModelProviderFactory
import com.test.testtiket.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {

    @JvmField
    @Inject
    var factory: ViewModelProviderFactory? = null


    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel
        get() = ViewModelProvider(this, factory!!).get(MainViewModel::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setNavigator(this)

        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() {
                    finish()
                }
            }
        onBackPressedDispatcher.addCallback(this, callback)
        setLoadMore()
    }

    private fun setLoadMore() {
        viewDataBinding?.rvList?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
                viewModel.loadMoreData(linearLayoutManager)

            }
        })
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun movePage() {

    }

    override fun handleError(throwable: Throwable?) {
        Toast.makeText(this, throwable?.message, Toast.LENGTH_SHORT).show()
    }

}