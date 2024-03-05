package com.dvnative.trailify.viewmodel

import android.content.Context

interface LoginViewModelInterface {
    val password: String
    val username: String
    val isUsernameInvalid: Boolean
    val usernameErrorMsg: String
    val passwordErrorMsg: String
    val isPasswordInvalid: Boolean
    val isEnabledSubmitButton: Boolean
    fun onUserNameValueChange(newValue: String)
    fun onPasswordValueChange(newValue: String)
    fun login(context: Context)
}