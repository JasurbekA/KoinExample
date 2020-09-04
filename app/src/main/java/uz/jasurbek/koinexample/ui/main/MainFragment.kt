package uz.jasurbek.koinexample.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.core.qualifier.named
import uz.jasurbek.koinexample.R
import uz.jasurbek.koinexample.ui.SharedViewModel
import uz.jasurbek.koinexample.util.Constants
import uz.jasurbek.koinexample.util.EventObserver

class MainFragment : Fragment(R.layout.fragment_main) {
    private val sharedViewModel: SharedViewModel by sharedViewModel()

    // private val mainViewModel : MainViewModel by viewModel()
    private val scope = getKoin().getOrCreateScope<MainFragment>(Constants.SCOPE_ID_MAIN_FRAGMENT)
    private val mainViewModel: MainViewModel by scope.viewModel(this)
    private val appName: String by scope.inject(named(Constants.APP_NAME))
    private val versionName: String by scope.inject(named(Constants.APP_VERSION))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }


    private fun initialize() {
        observeWelcomeMessage()
        observeUser()

    }

    private fun observeWelcomeMessage() {
        mainViewModel.welcomeText.observe(viewLifecycleOwner, EventObserver {
            val message = "$it\nApp name: $appName version $versionName"
            infoTextHolder.text = message
        })
    }

    private fun observeUser() {
        sharedViewModel.currentUser.observe(viewLifecycleOwner, Observer {
            mainViewModel.userDataLoaded(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        scope.close()
    }

}