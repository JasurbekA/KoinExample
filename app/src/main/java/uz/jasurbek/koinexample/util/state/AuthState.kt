package uz.jasurbek.koinexample.util.state

import uz.jasurbek.koinexample.data.model.User

sealed class AuthState {
    object OnLoading : AuthState()
    data class OnSuccess(val user: User) : AuthState()
    data class OnError(val message: String) : AuthState()
}