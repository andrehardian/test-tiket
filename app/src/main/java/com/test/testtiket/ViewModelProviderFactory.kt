package com.test.testtiket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.github.apps.domain.mappers.UserMapper
import com.github.apps.domain.usecases.user.IUserUsecases
import com.github.apps.domain.usecases.user.UserUsecases
import com.test.testtiket.data.remote.UserRepository
import com.test.testtiket.ui.activity.MainViewModel
import com.test.testtiket.util.SchedulerProvider

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelProviderFactory @Inject constructor(private val schedulerProvider: SchedulerProvider) : NewInstanceFactory() {
    private val userUsecases: IUserUsecases

    init {
        userUsecases = UserUsecases(UserMapper(), UserRepository.instance!!)
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                return MainViewModel(userUsecases, schedulerProvider) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }


}