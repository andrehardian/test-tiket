package com.test.testtiket.di.builder

import com.test.testtiket.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [])
    abstract fun bindMain(): MainActivity?
}