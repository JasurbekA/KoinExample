package uz.jasurbek.koinexample.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.jasurbek.koinexample.data.model.User

class SharedViewModel : ViewModel() {
    val currentUser = MutableLiveData<User>()
}