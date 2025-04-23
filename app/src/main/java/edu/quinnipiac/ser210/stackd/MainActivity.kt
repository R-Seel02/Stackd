package edu.quinnipiac.ser210.stackd

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import edu.quinnipiac.ser210.stackd.Navigation.AppNavigation
import edu.quinnipiac.ser210.stackd.Navigation.AppScreens
import edu.quinnipiac.ser210.stackd.Screen.MainScreen
import edu.quinnipiac.ser210.stackd.api.Exercise
import edu.quinnipiac.ser210.stackd.ui.theme.StackdTheme




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StackdTheme {
                val navController = rememberNavController()


                    AppNavigation(navController = navController)

            }
        }
    }
}



//    @Composable
//    fun GreetingPreview() {
//        StackdTheme {
//            val navController = rememberNavController()
//            MainScreen(
//                navController = navController,
//                modifier = Modifier.padding(16.dp) // Use a fixed padding for preview
//            )
//        }
//    }}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    StackdTheme {
//
//        MainScreen()
//    }
//}