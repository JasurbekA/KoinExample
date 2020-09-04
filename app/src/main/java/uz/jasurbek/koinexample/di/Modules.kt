package uz.jasurbek.koinexample.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import uz.jasurbek.koinexample.BuildConfig
import uz.jasurbek.koinexample.data.AuthRepository
import uz.jasurbek.koinexample.data.MainRepository
import uz.jasurbek.koinexample.ui.SharedViewModel
import uz.jasurbek.koinexample.ui.auth.AuthFragment
import uz.jasurbek.koinexample.ui.auth.AuthViewModel
import uz.jasurbek.koinexample.ui.main.MainFragment
import uz.jasurbek.koinexample.ui.main.MainViewModel
import uz.jasurbek.koinexample.util.Constants

/*val viewModelsModule = module {
    viewModel { MainViewModel(get(), get()) }
    viewModel { AuthViewModel(get()) }
    viewModel { SharedViewModel() }
}*/

/*

val repositoriesModule = module {
    single { AuthRepository() }
    single { MainRepository() }
}
*/


val mainFragment = module {
    scope(named<MainFragment>()) {
        viewModel { MainViewModel(get(), get()) }
        scoped { MainRepository() }
        scoped(named(Constants.APP_NAME)) { "KoinExampleAPP" }
        scoped(named(Constants.APP_VERSION)) { BuildConfig.VERSION_NAME }
    }
}

val authFragment = module {
    scope(named<AuthFragment>()) {
        viewModel { AuthViewModel(get()) }
        scoped { AuthRepository() }
    }
}

val appModule = module {
    viewModel { SharedViewModel() }
}

val appModules = listOf(appModule, mainFragment, authFragment)
//listOf(viewModelsModule, repositoriesModule)