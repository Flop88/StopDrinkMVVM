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
    var email: String = "",

    @ColumnInfo
    var name: String = "",

    @ColumnInfo
    var dateWhenStopDrink: String = "",

    @ColumnInfo
    var aboutMe: String = "",

    @ColumnInfo
    var profileImage: String = ""
)