package com.test.testtiket.domain.model

data class User(
        var avatar: String? = null,
        var name: String? = null,
        var score: Double? = null,
        var url: String? = null
) : BaseObject()