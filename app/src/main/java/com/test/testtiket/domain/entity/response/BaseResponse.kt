package com.github.apps.domain.entities.response

import com.google.gson.annotations.SerializedName
import com.test.testtiket.domain.entity.BaseObjectEntity
import com.test.testtiket.domain.entity.ErrorEntity

open class BaseResponse<E> : BaseObjectEntity() {
    var data: E? = null

    var errors: List<ErrorEntity>? = null

    @SerializedName("documentation_url")
    var documentationUrl: String? = null

}


