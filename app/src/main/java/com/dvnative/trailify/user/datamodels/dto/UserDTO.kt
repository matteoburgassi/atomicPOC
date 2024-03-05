package com.dvnative.trailify.user.datamodels.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
class UserDTO (
    val code: Long,
    val error: Long,
    val data: Data?
) {

    @Serializable
    data class Data (
        @SerialName("user_id")
        val userID: Long,
        @SerialName("userdve_ticket")
        val ticket: String? = null
    )
}