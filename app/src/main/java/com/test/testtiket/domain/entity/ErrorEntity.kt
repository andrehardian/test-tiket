package com.test.testtiket.domain.entity

data class ErrorEntity(
        var resource: String? = null,
        var field: String? = null,
        var code: String? = null
)