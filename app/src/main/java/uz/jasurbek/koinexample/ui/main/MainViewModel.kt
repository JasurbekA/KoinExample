package uz.jasurbek.koinexample.ui.main

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.jasurbek.koinexample.data.MainRepository
import uz.jasurbek.koinexample.data.model.User
import uz.jasurbek.koinexample.util.Event

class MainViewModel(
    private val context: Context,
    private val repository: MainRepository
) : ViewModel() {

    private val _welcomeText = MutableLiveData<Event<String>>()
    val welcomeText: LiveData<Event<String>>
        get() = _welcomeText

    init {
        _welcomeText.value = Event("")
    }


    fun userDataLoaded(user: User) {
        _welcomeText.value = Event(context.getString(repository.welcomeMessage(), user.name))
    }

}