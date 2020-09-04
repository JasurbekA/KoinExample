package uz.jasurbek.koinexample.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.jasurbek.koinexample.data.AuthRepository
import uz.jasurbek.koinexample.util.Event
import uz.jasurbek.koinexample.util.state.AuthState

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    private val _authState = MutableLiveData<Event<AuthState>>()
    val authState: LiveData<Event<AuthState>>
        get() = _authState


    fun authUser(username: String, password: String) {
        _authState.value = Event(AuthState.OnLoading)
        val user = repository.authUser(username, password)
        _authState.value =
            if (user == null) Event(AuthState.OnError("User not found"))
            else Event(AuthState.OnSuccess(user))
    }

}