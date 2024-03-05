package com.dvnative.trailify.user.authenticator

import com.dvnative.trailify.user.datamodels.Credentials
import com.dvnative.trailify.user.datamodels.dto.UserDTO

interface Authenticator {
    val credentials: Credentials
    suspend fun executeLogin(): UserDTO.Data?
}