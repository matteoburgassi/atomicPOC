package com.dvnative.trailify.user.datamodels.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserErrorDTO(
    val error: Error? = null
) {
    @Serializable
    data class Error(
        val code: String? = null,
        val extra: Extra? = null,
        val message: String? = null
    )
    @Serializable
    data class Extra(
        val contextId: String? = null
    )
}
