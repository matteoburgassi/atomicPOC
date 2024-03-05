package com.dvnative.trailify.user.repositories.login

import com.dvnative.trailify.user.datamodels.Credentials
import com.dvnative.trailify.user.datamodels.dto.UserDTO
import com.dvnative.trailify.user.datamodels.dvHash
import com.dvnative.trailify.user.repositories.UserRepository
import com.dvnative.trailify.user.services.NetworkService
import io.ktor.client.request.basicAuth
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.path

internal suspend fun UserRepository.usernameLoginCall(loginCredential: Credentials.Username): UserDTO? {
    return networkService.apiCall(NetworkService.RequestKind.POST) { requestBuilder ->
        requestBuilder.contentType(ContentType.Application.Json)

        requestBuilder.url {
            protocol = repoProtocol
            host = repoHost()
            path("login/dve")
            requestBuilder.parameter("service_id", serviceId())
            requestBuilder.parameter("login", loginCredential.value)
            requestBuilder.parameter("password_dve", loginCredential.password.dvHash)
            requestBuilder.basicAuth(basicAuthInfo.first, basicAuthInfo.second)
        }


        requestBuilder.setBody(loginCredential)
    }
}