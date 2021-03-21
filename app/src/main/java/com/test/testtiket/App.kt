package com.test.testtiket

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.test.testtiket.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class App : Application(), HasActivityInjector {

    companion object {
        var appContext: Context? = null
            private set
        var instance: App? = null
            private set
    }

    @JvmField
    @Inject
    var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null


    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appContext = applicationContext
        DaggerAppComponent.builder()
            .application(this)
            ?.build()
            ?.inject(this)
    }

}