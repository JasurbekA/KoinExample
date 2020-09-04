package uz.jasurbek.koinexample.data

import uz.jasurbek.koinexample.data.model.User
import uz.jasurbek.koinexample.data.model.UserCredential
import uz.jasurbek.koinexample.data.model.userCredentials
import uz.jasurbek.koinexample.data.model.userList

class AuthRepository {
    fun authUser(username: String, password: String) : User? {
        val userCredential =
            userCredentials.firstOrNull { it.username == username && it.password == password }
        return if (userCredential != null) getUser(userCredential) else null
    }

    private fun getUser(credential: UserCredential) : User {
        return userList.first { it.id == credential.id }
    }
}