package com.alcadiosystem.gamermvvmapp.presentation.screans.login

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
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
    //EMAIL
    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid:MutableState<Boolean> = mutableStateOf(false)
    var emailErrorMg: MutableState<String> = mutableStateOf("")
    //PASSWORD
    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid:MutableState<Boolean> = mutableStateOf(false)
    var passwordErrorMg: MutableState<String> = mutableStateOf("")
    //BUTTON
    var isEnabledLoginButton = false

    private val _loginFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val loginFlow: StateFlow<Response<FirebaseUser>?> = _loginFlow

    fun login() = viewModelScope.launch {
        _loginFlow.value = Response.Loading
        val result = authUseCase.login(email.value,password.value)
        _loginFlow.value = result
    }


    fun enabledLoginButton(){
        isEnabledLoginButton = isEmailValid.value && isPasswordValid.value
    }

    fun validateEmail(){
        if(email.value.isNotEmpty()){
            if(Patterns.EMAIL_ADDRESS.matcher(email.value).matches()){
                isEmailValid.value = true
                emailErrorMg.value = ""
            }else{
                isEmailValid.value = false
                emailErrorMg.value = "El email no es valido"
            }
        }
        enabledLoginButton()
    }

    fun validatePassword(){
        if(password.value.isNotEmpty()){
            if(password.value.length >= 6){
                isPasswordValid.value = true
                passwordErrorMg.value = ""
            }else{
                isPasswordValid.value = false
                passwordErrorMg.value = "Al menos 6 caracteres"
            }
        }
        enabledLoginButton()
    }
}