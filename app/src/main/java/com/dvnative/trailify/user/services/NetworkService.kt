package com.dvnative.trailify.user.services

import com.digitalvirgo.smartconfig.datamodels.dto.SmartConfigErrorDTO
import com.dvnative.trailify.user.datamodels.UserError
import com.dvnative.trailify.user.datamodels.dto.UserErrorDTO
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.post

object NetworkService {
    enum class RequestKind {
        POST, GET, PUT, DELETE
    }

    private val client = clientConfiguration()

    internal suspend inline fun <reified T> apiCall(
        kind: RequestKind,
        block: (HttpRequestBuilder) -> Unit,
    ): T? {
        val res = when (kind) {
            RequestKind.POST -> client.post {
                block(this)
            }

            RequestKind.GET -> client.get {
                block(this)
            }

            RequestKind.PUT -> TODO()
            RequestKind.DELETE -> TODO()
        }

        if (res.status.value in 200..299) {
            return res.body<T>()
        }
        val errorBody = res.body<UserErrorDTO>()
        throw UserError(errorBody)
    }
}