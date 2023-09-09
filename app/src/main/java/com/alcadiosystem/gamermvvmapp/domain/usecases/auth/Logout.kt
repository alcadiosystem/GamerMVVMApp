package com.alcadiosystem.gamermvvmapp.domain.usecases.auth

import com.alcadiosystem.gamermvvmapp.domain.repository.AuthRepository
import javax.inject.Inject

class Logout @Inject constructor(private val repository: AuthRepository){
    operator fun invoke() = repository.logout()
}