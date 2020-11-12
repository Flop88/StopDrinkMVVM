package ru.mvlikhachev.stopdrinkmvvm.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.mvlikhachev.stopdrinkmvvm.models.User
import ru.mvlikhachev.stopdrinkmvvm.utilits.REPOSITORY

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {

    suspend fun getCurrentUser(userId: Int): User {
        return REPOSITORY.getUser(userId = userId)
    }

    fun update(user: User, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.Main) {
            REPOSITORY.update(user) {
                onSuccess()
            }
        }

}