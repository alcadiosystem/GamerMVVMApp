package com.alcadiosystem.gamermvvmapp.domain.repository

import com.alcadiosystem.gamermvvmapp.domain.model.Response
import com.alcadiosystem.gamermvvmapp.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun create(user:User): Response<Boolean>
    suspend fun update(user:User): Response<Boolean>
    fun getUserById(id:String):Flow<User>

}