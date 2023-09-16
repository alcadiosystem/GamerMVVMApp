package com.alcadiosystem.gamermvvmapp.domain.usecases.users

import com.alcadiosystem.gamermvvmapp.domain.repository.UserRepository
import javax.inject.Inject

class GetUserById @Inject constructor(private val repository: UserRepository) {

    operator fun invoke(id:String) = repository.getUserById(id)


}