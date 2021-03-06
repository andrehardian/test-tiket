package com.github.apps.domain.entities.response

import com.google.gson.annotations.SerializedName
import com.test.testtiket.domain.entity.UserEntity


class UserResponse(
        @SerializedName("total_count") val totalCount: Int? = null,
        @SerializedName("incomplete_results") val incompleteResults: Boolean? = null,
        @SerializedName("items") val items: List<UserEntity>? = null
) : BaseResponse<Any>()