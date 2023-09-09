package com.alcadiosystem.gamermvvmapp.di

import com.alcadiosystem.gamermvvmapp.domain.repository.AuthRepository
import com.alcadiosystem.gamermvvmapp.data.AuthRepositoryImpl
import com.alcadiosystem.gamermvvmapp.domain.usecases.auth.AuthUseCase
import com.alcadiosystem.gamermvvmapp.domain.usecases.auth.GetCurrentUser
import com.alcadiosystem.gamermvvmapp.domain.usecases.auth.Login
import com.alcadiosystem.gamermvvmapp.domain.usecases.auth.Logout
import com.alcadiosystem.gamermvvmapp.domain.usecases.auth.Signup
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun providerFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl):AuthRepository = impl

    @Provides
    fun provideAuthUseCase(repository: AuthRepository) = AuthUseCase(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository),
        logout = Logout(repository),
        signup = Signup(repository)
    )
}