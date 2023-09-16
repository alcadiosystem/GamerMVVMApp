package com.alcadiosystem.gamermvvmapp.presentation.screans.login

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alcadiosystem.gamermvvmapp.domain.model.Response
import com.alcadiosystem.gamermvvmapp.domain.usecases.auth.AuthUseCase
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase) :ViewModel() {

    //STATE FORM
    var state by mutableStateOf(LoginState())
        private set

    //EMAIL
    private var isEmailValid:Boolean by mutableStateOf(false)
    var emailErrorMg: String by mutableStateOf("")
    //PASSWORD
    private var isPasswordValid:Boolean by mutableStateOf(false)
    var passwordErrorMg: String by mutableStateOf("")
    //BUTTON
    var isEnabledLoginButton = false

    //LOGIN RESPONSE
    var loginResponse by mutableStateOf<Response<FirebaseUser>?>(null)

    private val currentUser = authUseCase.getCurrentUser()

    init {
        if(currentUser != null){
            //Session iniciada
            loginResponse = Response.Success(currentUser)
        }
    }

    fun login() = viewModelScope.launch {
        loginResponse = Response.Loading
        val result = authUseCase.login(state.email,state.password)
        loginResponse = result
    }

    private fun enabledLoginButton(){
        isEnabledLoginButton = isEmailValid && isPasswordValid
    }

    fun validateEmail(){
        if(state.email.isNotEmpty()){
            if(Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
                isEmailValid = true
                emailErrorMg = ""
            }else{
                isEmailValid = false
                emailErrorMg = "El email no es valido"
            }
        }
        enabledLoginButton()
    }

    fun validatePassword(){
        if(state.password.isNotEmpty()){
            if(state.password.length >= 6){
                isPasswordValid = true
                passwordErrorMg = ""
            }else{
                isPasswordValid = false
                passwordErrorMg = "Al menos 6 caracteres"
            }
        }
        enabledLoginButton()
    }

    fun onEmailInput(email:String){
        state = state.copy(email = email)
    }

    fun onPasswordInput(password:String){
        state = state.copy(password = password)
    }
}