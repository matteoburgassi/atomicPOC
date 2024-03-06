package com.dvnative.trailify.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import com.dvnative.trailify.ui.components.InputField
import com.dvnative.trailify.ui.components.PasswordField
import com.dvnative.trailify.ui.components.PrimaryActiveButton
import com.dvnative.trailify.ui.components.Title
import com.dvnative.trailify.viewmodel.LoginViewModelInterface
import com.dvnative.trailify.viewmodel.mocks.LoginViewModelMock
import com.dvnative.trailify.ui.theme.AppTheme
import com.dvnative.trailify.ui.theme.extraValues
@Composable
fun Login(viewModel: LoginViewModelInterface) {
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    AppTheme {
        Column(Modifier.padding(horizontal = MaterialTheme.extraValues.sizes.containerHorizontalPadding)) {
            Title(text = "Sign in")

            InputField(
                value = viewModel.username,
                modifier = Modifier.fillMaxWidth(),
                testTag = "login_username_field",
                label = { Text("Username or phone number") },
                isError = viewModel.isUsernameInvalid,
                errorLabel = viewModel.usernameErrorMsg,
                focusManager = focusManager,
                onValueChange = { viewModel.onUserNameValueChange(it) }
            )

            PasswordField(
                value = viewModel.password,
                modifier = Modifier.fillMaxWidth(),
                testTag = "login_password_field",
                label = { Text("Password") },
                isError = viewModel.isPasswordInvalid,
                errorLabel = viewModel.passwordErrorMsg,
                focusManager = focusManager,
                onValueChange = { viewModel.onPasswordValueChange(it) }
            )

            PrimaryActiveButton(
                onClick = { viewModel.login(context)},
                text = "Connexion",
                enabled = viewModel.isEnabledSubmitButton)
        }
    }
}

@Composable
@Preview

fun LoginPreview() {
    val mockViewModel = LoginViewModelMock(
        usernameMock = "",
        usernameInvalidMock = false,
        usernameErrorMsgMock = "",
        isPasswordValidMock = true,
        passwordMock = "",
        isEnabledSubmitButtonMock = false
    )
    Surface (Modifier.background(MaterialTheme.extraValues.backgroundGradient),
        color = Color.Transparent) {
        Login(mockViewModel)
    }
}