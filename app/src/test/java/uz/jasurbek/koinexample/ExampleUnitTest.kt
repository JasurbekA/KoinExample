package uz.jasurbek.koinexample

import org.junit.Test

import org.junit.Assert.*
import org.junit.experimental.categories.Category
import org.koin.test.AutoCloseKoinTest
import org.koin.test.category.CheckModuleTest
import org.koin.test.check.checkModules
import uz.jasurbek.koinexample.di.appModule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@Category(CheckModuleTest::class)
class ExampleUnitTest : AutoCloseKoinTest() {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    /**
     * Checking module if there is any conflict in Dependency graph
     * */
    @Test
    fun checkKoinModules() : Unit = checkModules {
        modules(appModule)
    }
}

