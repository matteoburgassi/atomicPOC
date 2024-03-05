package com.dvnative.trailify.user

import android.util.Log
import com.digitalvirgo.smartconfig.datamodels.SmartConfiguration
import com.dvnative.trailify.user.authenticator.Authenticator
import com.dvnative.trailify.user.datamodels.UserError
import com.dvnative.trailify.user.datamodels.dto.UserDTO
import com.dvnative.trailify.user.repositories.UserRepository
import com.dvnative.trailify.user.services.NetworkService

object User {
    internal var repository: UserRepository? = null

    fun configure(configuration: () -> SmartConfiguration): User {
        repository = UserRepository(NetworkService, configuration())
        return this
    }
    @Throws(UserError::class, IllegalStateException::class)
    suspend fun login(
        authenticator: Authenticator,
    ): UserDTO.Data{
        val user = authenticator.executeLogin()

        user?.let {
            Log.d("login","user received: ${user.userID}, ${user.ticket}")
            return it
        }

        throw IllegalStateException("missing service configuration")
    }
}