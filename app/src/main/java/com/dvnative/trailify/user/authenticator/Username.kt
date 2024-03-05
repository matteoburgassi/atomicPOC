package com.dvnative.trailify.user.authenticator

import com.dvnative.trailify.user.User
import com.dvnative.trailify.user.datamodels.Credentials
import com.dvnative.trailify.user.datamodels.dto.UserDTO
import com.dvnative.trailify.user.repositories.login.usernameLoginCall

class Username (override val credentials: Credentials.Username) : Authenticator {
    override suspend fun executeLogin(): UserDTO.Data? {
        val dto = User.repository?.usernameLoginCall(credentials)
        return dto?.data
    }

}