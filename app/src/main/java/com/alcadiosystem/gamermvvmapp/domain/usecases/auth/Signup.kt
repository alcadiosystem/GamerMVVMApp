package com.alcadiosystem.gamermvvmapp.domain.usecases.auth

import com.alcadiosystem.gamermvvmapp.domain.model.User
import com.alcadiosystem.gamermvvmapp.domain.repository.AuthRepository
import javax.inject.Inject

class Signup @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User) = repository.singUp(user)

}