package com.alcadiosystem.gamermvvmapp.presentation.screans.profile


import androidx.lifecycle.ViewModel
import com.alcadiosystem.gamermvvmapp.domain.model.User
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.alcadiosystem.gamermvvmapp.domain.usecases.auth.AuthUseCase
import com.alcadiosystem.gamermvvmapp.domain.usecases.users.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val usersUseCase: UserUseCase
) : ViewModel() {

    var userData by mutableStateOf(User())
        private set
    private val currentUser = authUseCase.getCurrentUser()

    init {
        getUserById()
    }
    private fun getUserById() = viewModelScope.launch {
        usersUseCase.getUserById(currentUser!!.uid).collect(){
            userData = it
        }
    }

    fun logout() {
        authUseCase.logout()
    }

}