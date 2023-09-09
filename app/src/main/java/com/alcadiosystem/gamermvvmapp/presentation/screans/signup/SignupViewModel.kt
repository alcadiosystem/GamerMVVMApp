package com.alcadiosystem.gamermvvmapp.presentation.screans.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alcadiosystem.gamermvvmapp.domain.model.Response
import com.alcadiosystem.gamermvvmapp.domain.model.User
import com.alcadiosystem.gamermvvmapp.domain.usecases.auth.AuthUseCase
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {

    //USER
    var username: MutableState<String> = mutableStateOf("")
    var isUserName: MutableState<Boolean> = mutableStateOf(false)
    var userNameErrorMsg: MutableState<String> = mutableStateOf("")

    //PASSWORD
    var confirmPassword: MutableState<String> = mutableStateOf("")
    var isconfirmPassword: MutableState<Boolean> = mutableStateOf(false)
    var confirmPasswordErrorMsg: MutableState<String> = mutableStateOf("")

    //EMAIL
    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrorMg: MutableState<String> = mutableStateOf("")

    //PASSWORD
    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrorMg: MutableState<String> = mutableStateOf("")

    //BUTTON
    var isEnabledLoginButton = false

    private fun enabledSingUpButton() {
        isEnabledLoginButton =
            isUserName.value && isEmailValid.value && isPasswordValid.value && isconfirmPassword.value
    }

    fun validateUserName() {
        if (username.value.length >= 5) {
            isUserName.value = true
            userNameErrorMsg.value = ""
        } else {
            isUserName.value = false
            userNameErrorMsg.value = "El nombre de usuario no cumple"
        }
    }

    fun validateEmail() {
        if (email.value.isNotEmpty()) {
            if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
                isEmailValid.value = true
                emailErrorMg.value = ""
            } else {
                isEmailValid.value = false
                emailErrorMg.value = "El email no es valido"
            }
        }
    }

    fun validatePassword() {
        if (password.value.isNotEmpty()) {
            if (password.value.length >= 6) {
                isPasswordValid.value = true
                passwordErrorMg.value = ""
            } else {
                isPasswordValid.value = false
                passwordErrorMg.value = "Al menos 6 caracteres"
            }
        }
    }

    fun validateConfirmPassword() {
        if (confirmPassword.value == password.value) {
            isconfirmPassword.value = true
            confirmPasswordErrorMsg.value = ""
        } else {
            isconfirmPassword.value = false
            confirmPasswordErrorMsg.value = "Las contrasenas no coinciden"
        }
        enabledSingUpButton()
    }

    private val _signupFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val signupFlow: StateFlow<Response<FirebaseUser>?> = _signupFlow
    fun signup(user:User) = viewModelScope.launch {
        _signupFlow.value = Response.Loading
        val result = authUseCase.signup(user)
        _signupFlow.value = result
    }

    fun onSigun(){
        val user = User(
            name = username.value,
            email = email.value,
            password = password.value
        )
        signup(user)
    }

}