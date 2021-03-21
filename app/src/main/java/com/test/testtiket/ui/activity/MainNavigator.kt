package com.test.testtiket.ui.activity

import com.test.testiket.ui.base.BaseNavigator

interface MainNavigator : BaseNavigator {
    fun showError(message: String)
    fun movePage()
}