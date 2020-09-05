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

/**
 * Koin gives full power of modularization for Developers
 * This file contains all dependencies and modules for demo purpose
 * You can create separate file if it is required
 * */


/**
 * No scoping modularization example
 * More elegant, Bad performance, Bad memory management
 * */
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

/**
 * With scoping modularization example
 * More effort, Better performance, Better memory management
 * */
val mainFragment = module {
    scope(named<MainFragment>()) {
        viewModel { MainViewModel(get(), get()) }
        scoped { MainRepository() }
        /**
         * Injecting same types using named qualifier
         * */
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

val appModules =
    /**Scoping modularization modules*/
    listOf(appModule, mainFragment, authFragment)
/**No scoping modularization modules*/
//listOf(viewModelsModule, repositoriesModule)