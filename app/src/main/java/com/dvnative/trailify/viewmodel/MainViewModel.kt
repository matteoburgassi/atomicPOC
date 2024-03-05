package com.dvnative.trailify.viewmodel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitalvirgo.smartconfig.SmartConfig
import com.digitalvirgo.smartconfig.datamodels.SmartConfiguration
import com.dvnative.trailify.events.SplashLoginEvent
import com.dvnative.trailify.storage.Prefs
import com.dvnative.trailify.user.User
import com.dvnative.trailify.user.authenticator.Username
import com.dvnative.trailify.user.datamodels.Credentials
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel(), LoginViewModelInterface {
    private val _mainUiState = MutableStateFlow(SplashLoginEvent.StartConfiguration)
    val mainUiState: StateFlow<SplashLoginEvent> = _mainUiState.asStateFlow()
    var appConfiguration: SmartConfiguration? = null

    private val _debugOverriddenState = MutableStateFlow(false)
    val debugOverriddenState: StateFlow<Boolean> = _debugOverriddenState.asStateFlow()

    fun updateConfiguration() {
        viewModelScope.launch {
//            _debugOverriddenState.value = Prefs.getForcedCountry(getApplication()) != null
            _mainUiState.value = SplashLoginEvent.WaitingForConfiguration
            try{
                appConfiguration = SmartConfig.getSmartConfiguration()
                appConfiguration?.let { configuration ->
                    Log.d("updateConfiguration", "retrieved: ${configuration.countryCode}, ${configuration.packageName}")
                    User.configure {
                        configuration
                    }
                    _mainUiState.value = SplashLoginEvent.ConfigurationReceived
                }
            } catch (e: Exception){
                _mainUiState.value = SplashLoginEvent.ConfigurationError
            }
        }
    }

    suspend fun loadUserContext(context: Context) {
        _mainUiState.value = SplashLoginEvent.StartLoadingCredentials
        val user = Prefs.loadUser(context)
        if(!user.isNullOrEmpty()){
            _mainUiState.value = SplashLoginEvent.LoginSuccess
        } else {
            _mainUiState.value = SplashLoginEvent.CredentialsNotFound
        }
    }


    override var password by mutableStateOf("")
    override var username by mutableStateOf("")
    override var isUsernameInvalid by mutableStateOf(false)
    override var usernameErrorMsg by mutableStateOf("")
    override var isEnabledSubmitButton by mutableStateOf(false)
    override var isPasswordInvalid by mutableStateOf(false)
    override var passwordErrorMsg by mutableStateOf("")
    override fun onUserNameValueChange(newValue: String) {
        username = newValue
    }

    override fun onPasswordValueChange(newValue: String) {
        password = newValue
        if (newValue.length == 0) {
            isPasswordInvalid = false
            passwordErrorMsg = ""
        }
        shouldEnableLoginButton()
    }

    override fun login(context: Context) {
        _mainUiState.value = SplashLoginEvent.StartLoading
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                try {
                    val user = User.login(Username(Credentials.Username(username, password)))
                    Prefs.saveUser(context, "${user.userID}")
                    _mainUiState.value = SplashLoginEvent.LoginSuccess
                } catch (e: Exception) {
                    _mainUiState.value = SplashLoginEvent.LoginError
                    isPasswordInvalid = true
                    passwordErrorMsg = "Username or Password invalid"
                }
            }
        }
    }
    fun shouldEnableLoginButton() {
        isEnabledSubmitButton =
            usernameErrorMsg.isEmpty()
                    && username.isNotEmpty()
                    && password.isNotEmpty()
    }

}