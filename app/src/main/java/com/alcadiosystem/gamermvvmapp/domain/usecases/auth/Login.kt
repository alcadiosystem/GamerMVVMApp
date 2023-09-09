package com.alcadiosystem.gamermvvmapp.domain.usecases.auth

import com.alcadiosystem.gamermvvmapp.domain.repository.AuthRepository
import javax.inject.Inject

class Login @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(email:String, password:String) = repository.login(email, password)
}