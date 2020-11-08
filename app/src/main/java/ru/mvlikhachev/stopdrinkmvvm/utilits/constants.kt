package ru.mvlikhachev.stopdrinkmvvm.utilits

import ru.mvlikhachev.stopdrinkmvvm.MainActivity
import ru.mvlikhachev.stopdrinkmvvm.database.DatabaseRepository

lateinit var APP_ACTIVITY: MainActivity
lateinit var REPOSITORY:DatabaseRepository
const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"