package ru.mvlikhachev.stopdrinkmvvm.database

import androidx.lifecycle.LiveData
import ru.mvlikhachev.stopdrinkmvvm.models.User


interface DatabaseRepository {

    val allUsers: LiveData<List<User>>

    suspend fun insert(user: User, onSuccess:() -> Unit )
    suspend fun delete(user: User, onSuccess:() -> Unit )
    suspend fun getUser(userId: Int): User

}