package com.test.testtiket.di.module

import android.app.Application
import android.content.Context
import com.test.testtiket.util.AppSchedulerProvider
import com.test.testtiket.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }


}