package uz.jasurbek.koinexample.util.extentions

import android.widget.Toast
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.toast(message : String) = context?.let {
    Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.navigate(@IdRes destinationID: Int) {
    findNavController().navigate(destinationID)
}