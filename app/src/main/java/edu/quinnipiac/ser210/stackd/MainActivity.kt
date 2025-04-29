package edu.quinnipiac.ser210.stackd


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import edu.quinnipiac.ser210.stackd.Navigation.AppNavigation
import edu.quinnipiac.ser210.stackd.model.ThemeViewModel
import edu.quinnipiac.ser210.stackd.ui.theme.StackdTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3)
        installSplashScreen()

        setContent {
            val themeViewModel: ThemeViewModel = viewModel()

            val darkColors = darkColorScheme()
            val lightColors = lightColorScheme()




                val navController = rememberNavController()

                StackdTheme(darkTheme = themeViewModel.isDarkTheme) {
                    AppNavigation(navController = navController, themeViewModel = themeViewModel)
                }
            }
        }
    }



