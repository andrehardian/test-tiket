package com.github.apps.domain.usecases.base

import com.github.apps.domain.mappers.BaseMapper
import com.test.testtiket.data.remote.BaseRepository
import com.test.testtiket.data.remote.UserRepository

abstract class BaseUsecase<M : BaseMapper<*, *>?, R :
BaseRepository<*>?>(protected var mapper: M, protected var repository: UserRepository?) {

    fun isErrorCode(statusCode: Int): Boolean {
        if (statusCode > 200) {
            return true
        }
        return false
    }
}