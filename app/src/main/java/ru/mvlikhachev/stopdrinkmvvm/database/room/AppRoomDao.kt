package ru.mvlikhachev.stopdrinkmvvm.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.mvlikhachev.stopdrinkmvvm.models.User

@Dao
interface AppRoomDao {

    @Query("select * from users_tables")
    fun getAllUsers():LiveData<List<User>>

    @Query("select * from users_tables where id =:userId")
    fun getUserById(userId:Int) : User

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)

    @Update
    suspend fun update(user: User)

}