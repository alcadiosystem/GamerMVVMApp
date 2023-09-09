package com.alcadiosystem.gamermvvmapp.domain.usecases.auth

data class AuthUseCase (
    val getCurrentUser: GetCurrentUser,
    val login: Login,
    val logout: Logout,
    val signup: Signup
)