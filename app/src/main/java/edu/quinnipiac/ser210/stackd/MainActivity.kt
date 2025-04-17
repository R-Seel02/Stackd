package edu.quinnipiac.ser210.stackd

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
import edu.quinnipiac.ser210.stackd.Navigation.AppScreens
import edu.quinnipiac.ser210.stackd.Screen.MainScreen
import edu.quinnipiac.ser210.stackd.ui.theme.StackdTheme



@Composable
fun MainScreen(navController: NavController, modifier: Modifier) {
    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = { navController.navigate(AppScreens.SettingScreen.name) }) {
            Text(text = "Go to Setting Screen")
        }
        Button(onClick = { navController.navigate(AppScreens.AlmanacScreen.name) }) {
            Text(text = "Go to Almanac Screen")
        }
        Button(onClick = { navController.navigate(AppScreens.SplitScreen.name) }) {
            Text(text = "Go to Split Screen")
        }
    }
}
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContent {
//            StackdTheme {
//                val navController = rememberNavController()
//                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
//                    // Replace AppNavigation with the correct function or define it
//                    MainScreen(navController = navController, modifier = Modifier.padding(paddingValues))
//                }
//        }
//    }
//}
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//
//        enableEdgeToEdge()
//
//        val stackdViewModel: StackdViewModel by viewModels()
//        setContent {
//            StackdTheme {
//                val navController = rememberNavController()
//                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
//                    MainScreen(
//                        navController = navController,
//                        stackdViewModel = stackdViewModel
//                    )
//                }
//            }
//        }
//    }
//}


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

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    StackdTheme {
//
//        MainScreen()
//    }
//}