package ru.mvlikhachev.stopdrinkmvvm.database.room

import androidx.lifecycle.LiveData
import ru.mvlikhachev.stopdrinkmvvm.database.DatabaseRepository
import ru.mvlikhachev.stopdrinkmvvm.models.User

class AppRoomRepository(private val appRoomDao: AppRoomDao) :DatabaseRepository {


    override val allUsers: LiveData<List<User>>
        get() = appRoomDao.getAllUsers()

    override suspend fun insert(user: User, onSuccess: () -> Unit) {
        appRoomDao.insert(user)
    }

    override suspend fun delete(user: User, onSuccess: () -> Unit) {
        appRoomDao.delete(user)
    }




}