package ru.mvlikhachev.stopdrinkmvvm.screens.room_login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.mvlikhachev.stopdrinkmvvm.models.User
import ru.mvlikhachev.stopdrinkmvvm.utilits.REPOSITORY

class InputDataFragmentViewModel(application: Application) : AndroidViewModel(application) {

    fun insetr(user: User, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.Main) {
            REPOSITORY.insert(user) {
                onSuccess()
            }
        }


}