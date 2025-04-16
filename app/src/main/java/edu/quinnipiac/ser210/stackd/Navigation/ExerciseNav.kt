package edu.quinnipiac.ser210.stackd.Navigation

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import edu.quinnipiac.ser210.stackd.model.StackdViewModel
import edu.quinnipiac.ser210.stackd.Navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    currentScreen: String,
    navController: NavController,
    navigateUp: () -> Unit,
    modifier: Modifier
) {
    val canNavigateBack = navController.previousBackStackEntry != null
    Log.d("canNavigateBack",canNavigateBack.toString());
    TopAppBar(
        title = { Text("Home Screen") },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondary
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = ""
                    )
                }
            }
        }
    )
}
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val StackdViewModel: StackdViewModel.StackdViewModel = viewModel()
    StackdViewModel.getData()


    Scaffold(
        topBar = {
            AppBar(
                currentScreen = "Almanac",
                navController = navController,
                // canNavigateBack = true, //navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                modifier = Modifier
            )
        }
    ) { innerPadding ->
        NavHost(navController = navController,
            startDestination = AppScreens.MainScreen.name,
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding)){
            composable(AppScreens.HomeScreen.name) {

                HomeScreen(navController = navController,StackdViewModel)
            }
            composable(AppScreens.DetailScreen.name +"/{name}",
                arguments = listOf(navArgument(name = "name"){type = NavType.StringType})){
                    backStackEntry ->
                DetailsScreen(
                    navController = navController,StackdViewModel,
                    backStackEntry . arguments ?. getString ("name"),
                )

            }


        }
    }


}