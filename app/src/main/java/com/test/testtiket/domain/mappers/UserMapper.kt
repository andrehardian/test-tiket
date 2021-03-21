package com.github.apps.domain.mappers

import com.test.testtiket.domain.entity.UserEntity
import com.test.testtiket.domain.exceptions.MapperException
import com.test.testtiket.domain.model.User

class UserMapper : BaseMapper<UserEntity?, User?>() {
    override fun createObject(): User? {
        return User()
    }

    override fun createEntity(): UserEntity? {
        return UserEntity()
    }

    @Throws(MapperException::class)
    override fun defineObject(`object`: User?): User? {
        `object`?.avatar = baseEntity?.avatarUrl
        `object`?.name = baseEntity?.login
        `object`?.score = baseEntity?.score
        `object`?.url = baseEntity?.url
        return `object`
    }

    @Throws(MapperException::class)
    override fun defineEntity(entity: UserEntity?): UserEntity? {
        return entity
    }
}