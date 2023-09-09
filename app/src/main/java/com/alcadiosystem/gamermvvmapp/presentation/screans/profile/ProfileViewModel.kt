package com.alcadiosystem.gamermvvmapp.presentation.screans.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import com.alcadiosystem.gamermvvmapp.domain.usecases.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    fun logout(){
        Log.d("JDJDJDJ","FUNIONA logout() 2")
        authUseCase.logout()
    }

}