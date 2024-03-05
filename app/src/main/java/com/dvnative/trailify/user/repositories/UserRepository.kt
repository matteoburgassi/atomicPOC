package com.dvnative.trailify.user.repositories

import com.digitalvirgo.smartconfig.datamodels.SmartConfiguration
import com.dvnative.trailify.user.services.NetworkService
import io.ktor.http.URLProtocol

class UserRepository(
    internal val networkService: NetworkService,
    internal val configuration: SmartConfiguration
) {
    val repoHost = {
        when(configuration.userAccounting) {
            "kliento" -> {
                "userv1-pp.dv-content.io"//userv1-pp.dv-content.io
            }
            "userDVE" -> {
                "user.contactdve.com"
            }
            else -> {
                throw  Error("missing userAccounting" )
            }
        }
    }
    val serviceId = {
        when(configuration.userAccounting) {
            "kliento" -> {
                configuration.atom?.productID
            }
            "userDVE" -> {
                configuration.userDVE?.serviceID
            }
            else -> {
                throw  Error("missing userAccounting" )
            }
        }
    }

    val repoProtocol = URLProtocol.HTTPS
    val basicAuthInfo = Pair("app_playvod", "ApPpLAyVDvFs10*")
}