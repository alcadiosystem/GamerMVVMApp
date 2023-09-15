package com.alcadiosystem.gamermvvmapp.domain.repository

import com.alcadiosystem.gamermvvmapp.domain.model.Response
import com.alcadiosystem.gamermvvmapp.domain.model.User

interface UserRepository {

    suspend fun create(user:User): Response<Boolean>

}