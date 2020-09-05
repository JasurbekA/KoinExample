package uz.jasurbek.koinexample.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.jasurbek.koinexample.data.model.User
/**
 * Demo SharedViewModel to show injecting common
 * VM in Fragment and Activity as well
 * */
class SharedViewModel : ViewModel() {
    /**User can be observed from all child Fragments and underlying Activity as well*/
    val currentUser = MutableLiveData<User>()
}