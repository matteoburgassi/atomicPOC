package com.dvnative.trailify.viewmodel.mocks

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.dvnative.trailify.viewmodel.LoginViewModelInterface

class LoginViewModelMock(
    val passwordMock: String = "",
    val usernameMock: String = "",
    val usernameInvalidMock: Boolean = false,
    val usernameErrorMsgMock: String = "",
    val isEnabledSubmitButtonMock: Boolean = false,
    val passwordErrorMsgMock: String = "",
    val isPasswordValidMock: Boolean = false,
) : LoginViewModelInterface {
    override var password by mutableStateOf(passwordMock)
    override var username by mutableStateOf(usernameMock)
    override var isUsernameInvalid by mutableStateOf(usernameInvalidMock)
    override var usernameErrorMsg by mutableStateOf(usernameErrorMsgMock)
    override val isPasswordInvalid by mutableStateOf(isPasswordValidMock)
    override var passwordErrorMsg by mutableStateOf(passwordErrorMsgMock)
    override var isEnabledSubmitButton by mutableStateOf(isEnabledSubmitButtonMock)
    override fun onUserNameValueChange(newValue: String) {
        print("onUserNameValueChange value changed $newValue")
        username = newValue
    }

    override fun onPasswordValueChange(newValue: String) {
        print("onPasswordValueChange value changed $newValue")
        password = newValue
    }

    override fun login(context: Context) {
        print("login")
    }

}