package com.alcadiosystem.gamermvvmapp.presentation.screans.profile.profile_edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alcadiosystem.gamermvvmapp.domain.model.Response
import com.alcadiosystem.gamermvvmapp.domain.model.User
import com.alcadiosystem.gamermvvmapp.domain.usecases.users.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileEditViewModel@Inject constructor(
    private val saveStateHandle: SavedStateHandle,
    private val useCase: UserUseCase
) : ViewModel() {


    //STATE FORM
    var state by mutableStateOf(ProfileEditState())
        private set

    var userNameErrorMsg by mutableStateOf("")
        private set

    private var data = saveStateHandle.get<String>("user")
    val user = User.fromJson(data!!)

    var updateResponse by mutableStateOf<Response<Boolean>?>(null)
        private set

    init {
        state = state.copy(username = user.name)
    }

    fun onUserNameInput(username:String){
        state = state.copy(username = username)
    }

    fun onUpdate(){
        val myUser = User(
            id = user.id,
            name = state.username,
            image = ""
        )
        update(myUser)
    }

    fun update(user:User)= viewModelScope.launch {
        updateResponse = Response.Loading
        val result = useCase.update(user)
        updateResponse = result
    }

    fun validateUserName() {
        userNameErrorMsg = if (state.username.length >= 5) { "" }
        else { "El nombre de usuario no cumple" }
    }

}