package com.alcadiosystem.gamermvvmapp.presentation.screans.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alcadiosystem.gamermvvmapp.domain.model.Response
import com.alcadiosystem.gamermvvmapp.domain.model.User
import com.alcadiosystem.gamermvvmapp.domain.usecases.auth.AuthUseCase
import com.alcadiosystem.gamermvvmapp.domain.usecases.users.UserUseCase
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val userUseCase: UserUseCase
) : ViewModel() {

    //STATE FORM
    var state by mutableStateOf(SignupState())

    //USER
    private var isUserName by mutableStateOf(false)
    var userNameErrorMsg by mutableStateOf("")
        private set

    //PASSWORD
    private var isconfirmPassword by mutableStateOf(false)
    var confirmPasswordErrorMsg by mutableStateOf("")
        private set

    //EMAIL
    private var isEmailValid by mutableStateOf(false)
    var emailErrorMg by mutableStateOf("")
        private set

    //PASSWORD
    private var isPasswordValid by mutableStateOf(false)
    var passwordErrorMg by mutableStateOf("")
        private set

    //BUTTON
    var isEnabledLoginButton = false

    //SIGNUP
    var signupResponse by mutableStateOf<Response<FirebaseUser>?>(null)
        private set

    val user = User()

    private fun enabledSingUpButton() {
        isEnabledLoginButton =
            isUserName && isEmailValid && isPasswordValid && isconfirmPassword
    }

    fun validateUserName() {
        if (state.username.length >= 5) {
            isUserName = true
            userNameErrorMsg = ""
        } else {
            isUserName = false
            userNameErrorMsg = "El nombre de usuario no cumple"
        }
    }

    fun validateEmail() {
        if (state.email.isNotEmpty()) {
            if (Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
                isEmailValid = true
                emailErrorMg = ""
            } else {
                isEmailValid = false
                emailErrorMg = "El email no es valido"
            }
        }
    }

    fun validatePassword() {
        if (state.password.isNotEmpty()) {
            if (state.password.length >= 6) {
                isPasswordValid = true
                passwordErrorMg = ""
            } else {
                isPasswordValid = false
                passwordErrorMg = "Al menos 6 caracteres"
            }
        }
    }

    fun validateConfirmPassword() {
        if (state.confirmPassword == state.password) {
            isconfirmPassword = true
            confirmPasswordErrorMsg = ""
        } else {
            isconfirmPassword = false
            confirmPasswordErrorMsg = "Las contrasenas no coinciden"
        }
        enabledSingUpButton()
    }


    fun signup(user: User) = viewModelScope.launch {
        signupResponse = Response.Loading
        val result = authUseCase.signup(user)
        signupResponse = result
    }

    fun onSigun() {
        user.name = state.username
        user.email = state.email
        user.password = state.password
        signup(user)
    }

    fun createUser() = viewModelScope.launch{
        user.id = authUseCase.getCurrentUser()!!.uid
        userUseCase.create(user)
    }

    fun onUserNameInput(username:String){
        state = state.copy(username = username)
    }

    fun onEmailInput(email:String){
        state = state.copy(email = email)
    }

    fun onPasswordInput(password:String){
        state = state.copy(password = password)
    }

    fun onConfirmPasswordInput(confirmPassword:String){
        state = state.copy(confirmPassword = confirmPassword)
    }
}