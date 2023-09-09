package com.alcadiosystem.gamermvvmapp.domain.repository

import com.alcadiosystem.gamermvvmapp.domain.model.Response
import com.alcadiosystem.gamermvvmapp.domain.model.User
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {

    val currentUser:FirebaseUser?

    suspend fun login(email:String, password:String):Response<FirebaseUser>
    fun logout()

    suspend fun singUp(user:User): Response<FirebaseUser>
}