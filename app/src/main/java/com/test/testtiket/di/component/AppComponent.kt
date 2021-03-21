package com.test.testtiket.di.component

import android.app.Application
import com.test.testtiket.App
import com.test.testtiket.di.builder.ActivityBuilder
import com.test.testtiket.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent {
    fun inject(app: App?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application?): Builder?

        fun build(): AppComponent?
    }
}