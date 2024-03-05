package com.dvnative.trailify.events

enum class SplashLoginEvent {
    ConfigurationReceived,
    ConfigurationError,
    StartConfiguration,
    WaitingForConfiguration,
    StartLoadingCredentials,
    CredentialsNotFound,
    StartLoading,
    LoginError,
    LoginSuccess,
}