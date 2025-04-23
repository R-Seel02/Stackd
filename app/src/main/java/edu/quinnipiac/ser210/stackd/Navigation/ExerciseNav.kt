package edu.quinnipiac.ser210.stackd.Navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.quinnipiac.ser210.stackd.Screen.AlmanacScreen
import edu.quinnipiac.ser210.stackd.Screen.MainScreen
import edu.quinnipiac.ser210.stackd.Screen.SettingScreen
import edu.quinnipiac.ser210.stackd.Screen.SplitScreen
import edu.quinnipiac.ser210.stackd.model.stackdViewModel


@Composable
fun AppNavigation(navController: NavHostController) {
    val stackdViewModel: stackdViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = AppScreens.MainScreen.name
    ) {
        composable(AppScreens.MainScreen.name) {
            MainScreen(
                navController = navController,
                modifier = Modifier.padding(),
                stackdViewModel = stackdViewModel
            )
        }
        composable(AppScreens.SettingScreen.name) {
            SettingScreen(
                navController = navController,
                modifier = Modifier.padding(),
                stackdViewModel = stackdViewModel
            )
        }
        composable(AppScreens.AlmanacScreen.name) {
            AlmanacScreen( navController = navController,
                modifier = Modifier.padding(),
                stackdViewModel = stackdViewModel)
        }
        composable(AppScreens.SplitScreen.name) {
            SplitScreen()
        }
    }
}
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AppBar(
//    currentScreen: String,
//    navController: NavController,
//    navigateUp: () -> Unit,
//    modifier: Modifier
//) {
//    val canNavigateBack = navController.previousBackStackEntry != null
//    Log.d("canNavigateBack",canNavigateBack.toString());
//    TopAppBar(
//        title = { Text("Home Screen") },
//        colors = TopAppBarDefaults.mediumTopAppBarColors(
//            containerColor = MaterialTheme.colorScheme.secondary
//        ),
//        modifier = modifier,
//        navigationIcon = {
//            if (canNavigateBack) {
//                IconButton(onClick = navigateUp) {
//                    Icon(
//                        imageVector = Icons.Default.KeyboardArrowUp,
//                        contentDescription = ""
//                    )
//                }
//            }
//        }
//    )
//}
//@OptIn(ExperimentalAnimationApi::class)
//@Composable
//fun AppNavigation() {
//    val navController = rememberNavController()
//    val StackdViewModel: StackdViewModel.StackdViewModel = viewModel()
//    StackdViewModel.getData()
//
//
//    Scaffold(
//        topBar = {
//            AppBar(
//                currentScreen = "Almanac",
//                navController = navController,
//                // canNavigateBack = true, //navController.previousBackStackEntry != null,
//                navigateUp = { navController.navigateUp() },
//                modifier = Modifier
//            )
//        }
//    ) { innerPadding ->
//        NavHost(navController = navController,
//            startDestination = AppScreens.MainScreen.name,
//            modifier = Modifier.fillMaxSize()
//                .padding(innerPadding)){
//            composable(AppScreens.HomeScreen.name) {
//
//                HomeScreen(navController = navController,StackdViewModel)
//            }
//            composable(AppScreens.DetailScreen.name +"/{name}",
//                arguments = listOf(navArgument(name = "name"){type = NavType.StringType})){
//                    backStackEntry ->
//                DetailsScreen(
//                    navController = navController,StackdViewModel,
//                    backStackEntry . arguments ?. getString ("name"),
//                )
//
//            }
//
//
//        }
//    }
//
//
//}