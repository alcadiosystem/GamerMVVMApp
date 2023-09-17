package com.alcadiosystem.gamermvvmapp.data

import com.alcadiosystem.gamermvvmapp.domain.model.Response
import com.alcadiosystem.gamermvvmapp.domain.model.User
import com.alcadiosystem.gamermvvmapp.domain.repository.UserRepository
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userRef:CollectionReference): UserRepository {

    override suspend fun create(user: User): Response<Boolean> {
        return try {
            user.password = ""
            userRef.document(user.id).set(user).await()
            Response.Success(true)
        }catch (e:Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override suspend fun update(user:User): Response<Boolean> {
        return try {
            val map:MutableMap<String,Any> = HashMap()
            map["name"] = user.name
            map["image"] = user.image
            userRef.document(user.id).update(map).await()
            Response.Success(true)
        }catch (e:Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override fun getUserById(id: String): Flow<User> = callbackFlow {
        val snapshotListener = userRef.document(id).addSnapshotListener{
            snapshot, e ->
            val user = snapshot?.toObject(User::class.java)
            if (user != null) {
                trySend(user)
            }
        }
        awaitClose {
            snapshotListener.remove()
        }
    }
}