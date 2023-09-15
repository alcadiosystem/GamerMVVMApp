package com.alcadiosystem.gamermvvmapp.domain.usecases.users

import com.alcadiosystem.gamermvvmapp.domain.model.User
import com.alcadiosystem.gamermvvmapp.domain.repository.UserRepository
import javax.inject.Inject

class Create @Inject constructor(private val repository: UserRepository) {

    suspend operator fun invoke(user: User) = repository.create(user)

}