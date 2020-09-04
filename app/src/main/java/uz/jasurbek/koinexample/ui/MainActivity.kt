package uz.jasurbek.koinexample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.jasurbek.koinexample.R

class MainActivity : AppCompatActivity() {
    val sharedViewModel : SharedViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}