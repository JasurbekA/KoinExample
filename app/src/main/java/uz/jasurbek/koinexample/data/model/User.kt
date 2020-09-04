package uz.jasurbek.koinexample.data.model

data class User(
    val id: Int,
    val name: String,
    val gender: String
)

data class UserCredential(
    val id : Int,
    val password: String,
    val username : String
)

val userList = arrayListOf(
    User(0, "Abdulloh", "Erkak"),
    User(1, "Xadicha", "Ayol"),
    User(2, "Abdurahmon", "Erkak"),
    User(3, "Oisha", "Ayol")
)

val userCredentials = arrayListOf(
    UserCredential(0, "12345", "Abdulloh"),
    UserCredential(1, "123456", "Xadicha"),
    UserCredential(2, "1234567", "Abdurahmon"),
    UserCredential(3, "12345678", "Oisha")
)