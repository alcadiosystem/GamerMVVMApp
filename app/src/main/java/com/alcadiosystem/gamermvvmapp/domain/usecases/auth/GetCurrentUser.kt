package com.alcadiosystem.gamermvvmapp.domain.usecases.auth

import com.alcadiosystem.gamermvvmapp.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUser @Inject constructor(private val repository: AuthRepository) {

    operator fun invoke() = repository.currentUser

}