package uz.jasurbek.koinexample.data.model

/**User Object for holding user info*/
data class User(
    val id: Int,
    val name: String,
    val gender: String
)

/**Object for holding user credentials*/
data class UserCredential(
    val id : Int,
    val password: String,
    val username : String
)

/**Existing users*/
val userList = arrayListOf(
    User(0, "Abdulloh", "Erkak"),
    User(1, "Xadicha", "Ayol"),
    User(2, "Abdurahmon", "Erkak"),
    User(3, "Oisha", "Ayol")
)
/**Corresponding credentials of existing users*/
val userCredentials = arrayListOf(
    UserCredential(0, "12345", "Abdulloh"),
    UserCredential(1, "123456", "Xadicha"),
    UserCredential(2, "1234567", "Abdurahmon"),
    UserCredential(3, "12345678", "Oisha")
)