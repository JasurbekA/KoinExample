package uz.jasurbek.koinexample.ui.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_auth.*
import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.scope.viewModel
import uz.jasurbek.koinexample.R
import uz.jasurbek.koinexample.data.model.User
import uz.jasurbek.koinexample.ui.SharedViewModel
import uz.jasurbek.koinexample.util.Constants
import uz.jasurbek.koinexample.util.EventObserver
import uz.jasurbek.koinexample.util.extentions.navigate
import uz.jasurbek.koinexample.util.extentions.toast
import uz.jasurbek.koinexample.util.state.AuthState

class AuthFragment : Fragment(R.layout.fragment_auth) {
    private val sharedViewModel: SharedViewModel by sharedViewModel()

    /**Without Scope
     * NOT RECOMMENDED
     * */
    //private val authViewModel: AuthViewModel by viewModel()
    /**
     * With Scope
     * Create a scope with ID
     * Inject using that scope
     * */
    private val authScope = getKoin().getOrCreateScope<AuthFragment>(Constants.SCOPE_ID_AUTH_FRAGMENT)
    private val authViewModel: AuthViewModel by authScope.viewModel(this)

    private val loginBtnClickListener = View.OnClickListener {
        val username = usernameField.text.toString().trim()
        val password = passwordField.text.toString().trim()
        if (username.isEmpty() || password.isEmpty()) {
            toast("Please enter valid input")
            return@OnClickListener
        }
        authViewModel.authUser(username, password)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        setupListeners()
        setupObservers()
    }


    private fun setupListeners() {
        loginBtn.setOnClickListener(loginBtnClickListener)
    }

    private fun setupObservers() {
        authViewModel.authState.observe(viewLifecycleOwner, EventObserver{state->
            when (state) {
                is AuthState.OnLoading -> {}
                is AuthState.OnError -> toast(state.message)
                is AuthState.OnSuccess -> authSuccess(state.user)
            }
        })
    }

    private fun authSuccess(user: User) {
        sharedViewModel.currentUser.value = user
        navigate(R.id.mainFragment)
    }

    /**
     * Clear up scope so that We can sure no reference exist after destroying View
     * We will not get MEMORY_LEAK
     * Destroying scope tells GC memory locations are ready to be reclaimed
     * */
    override fun onDestroyView() {
        super.onDestroyView()
        authScope.close()
    }
}