package edu.quinnipiac.ser210.stackd

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import edu.quinnipiac.ser210.stackd.Screen.AlmanacScreen


import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext =
        assertEquals("edu.quinnipiac.ser210.stackd", appContext.packageName)
    }


    @Test
    fun almanacScreenDisplaysCorrectly() {

            AlmanacScreen(
                navController = androidx.navigation.testing.TestNavHostController(composeTestRule.activity),
                stackdViewModel = stackdViewModel()
            )


        // Add assertions to verify UI elements
    }
}