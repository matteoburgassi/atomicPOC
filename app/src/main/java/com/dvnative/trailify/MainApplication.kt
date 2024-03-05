package com.dvnative.trailify

import android.app.Application
import com.digitalvirgo.smartconfig.SmartConfig

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        SmartConfig.configure {
            com.digitalvirgo.smartconfig.ServiceConfig(
                name = "playvod",
                secret = "Yj685npK",
                forcedCountry = "EG",
                applicationId = "361",
                login = "PlayVodMax_Ios",
                password = "912ai6xn",
                wantedVersion = "1"
            )
        }
    }
}
