package uz.jasurbek.koinexample.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.jasurbek.koinexample.data.AuthRepository
import uz.jasurbek.koinexample.util.Event
import uz.jasurbek.koinexample.util.state.AuthState

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    /**
     * AuthState can be observed in View
     * */
    private val _authState = MutableLiveData<Event<AuthState>>()
    val authState: LiveData<Event<AuthState>>
        get() = _authState

    /**
     * Fake User authentication using local data for demo
     * @param {AuthState.OnLoading} when auth process is running
     * @param {AuthState.OnError} when something went wrong
     * @param {AuthState.OnSuccess} when everything goes well and without error
     * */
    fun authUser(username: String, password: String) {
        /**Emit Loading state so that UI can show Loading info*/
        _authState.value = Event(AuthState.OnLoading)
        val user = repository.authUser(username, password)
        _authState.value =
            /**User not found*/
            if (user == null) Event(AuthState.OnError("User not found"))
            /**Yaa User is exist*/
            else Event(AuthState.OnSuccess(user))
    }

}