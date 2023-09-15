package com.alcadiosystem.gamermvvmapp.di

import com.alcadiosystem.gamermvvmapp.core.Constants.USERS
import com.alcadiosystem.gamermvvmapp.domain.repository.AuthRepository
import com.alcadiosystem.gamermvvmapp.data.AuthRepositoryImpl
import com.alcadiosystem.gamermvvmapp.data.UserRepositoryImpl
import com.alcadiosystem.gamermvvmapp.domain.repository.UserRepository
import com.alcadiosystem.gamermvvmapp.domain.usecases.auth.AuthUseCase
import com.alcadiosystem.gamermvvmapp.domain.usecases.auth.GetCurrentUser
import com.alcadiosystem.gamermvvmapp.domain.usecases.auth.Login
import com.alcadiosystem.gamermvvmapp.domain.usecases.auth.Logout
import com.alcadiosystem.gamermvvmapp.domain.usecases.auth.Signup
import com.alcadiosystem.gamermvvmapp.domain.usecases.users.Create
import com.alcadiosystem.gamermvvmapp.domain.usecases.users.UserUseCase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    fun provideUsersRef(db: FirebaseFirestore): CollectionReference = db.collection(USERS)

    @Provides
    fun providerFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl):AuthRepository = impl

    @Provides
    fun provideUsersRepository(impl: UserRepositoryImpl): UserRepository = impl

    @Provides
    fun provideAuthUseCase(repository: AuthRepository) = AuthUseCase(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository),
        logout = Logout(repository),
        signup = Signup(repository)
    )

    @Provides
    fun provideUsersUseCases(repository: UserRepository) = UserUseCase(
        create = Create(repository)
    )
}