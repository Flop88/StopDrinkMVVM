package ru.mvlikhachev.stopdrinkmvvm.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.mvlikhachev.stopdrinkmvvm.database.room.AppRoomDatabase
import ru.mvlikhachev.stopdrinkmvvm.database.room.AppRoomRepository
import ru.mvlikhachev.stopdrinkmvvm.utilits.REPOSITORY
import ru.mvlikhachev.stopdrinkmvvm.utilits.TYPE_ROOM

class StartFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application

    fun initDatabase(type: String, onSuccess: () -> Unit) {
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
        }
    }

}