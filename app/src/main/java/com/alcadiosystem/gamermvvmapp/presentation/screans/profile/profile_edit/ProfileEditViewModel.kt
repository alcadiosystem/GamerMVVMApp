package com.alcadiosystem.gamermvvmapp.presentation.screans.profile.profile_edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.alcadiosystem.gamermvvmapp.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileEditViewModel@Inject constructor(
    private val saveStateHandle: SavedStateHandle
) : ViewModel() {


    //STATE FORM
    var state by mutableStateOf(ProfileEditState())
        private set

    var userNameErrorMsg by mutableStateOf("")
        private set

    private var data = saveStateHandle.get<String>("user")
    val user = User.fromJson(data!!)

    init {
        state = state.copy(username = user.name)
    }

    fun onUserNameInput(username:String){
        state = state.copy(username = username)
    }

    fun validateUserName() {
        userNameErrorMsg = if (state.username.length >= 5) { "" }
        else { "El nombre de usuario no cumple" }
    }

}