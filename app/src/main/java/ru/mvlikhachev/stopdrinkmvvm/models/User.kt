package ru.mvlikhachev.stopdrinkmvvm.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_tables")
data class User(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo
    val firebaseId: String = "",

    @ColumnInfo
    val email: String = "",

    @ColumnInfo
    val name: String = "",

    @ColumnInfo
    val dateWhenStopDrink: String = "",

    @ColumnInfo
    val aboutMe: String = "",

    @ColumnInfo
    val profileImage: String = ""
)