package edu.quinnipiac.ser210.stackd.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.quinnipiac.ser210.stackd.Navigation.AppScreens
import edu.quinnipiac.ser210.stackd.model.stackdViewModel


@Composable
@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MainScreen(
//    navController : NavController, stackdViewModel : stackdViewModel, modifier: Modifier
//)
//{
//  val exerciseResult = stackdViewModel.exerciseResult.observeAsState()
//
//    val workoutsList = exerciseResult.value?.body()
//    val workoutsListNonNullable = workoutsList?.filterNotNull() ?: emptyList()
//
//    Column(modifier = Modifier.padding(12.dp)) {
//
//
//    }
//}

fun MainScreen(
  navController: NavController,
  modifier: Modifier = Modifier,
  stackdViewModel: stackdViewModel
) {
  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text("Stackd") },
        actions = {
          IconButton(onClick = {
            navController.navigate(AppScreens.SettingScreen.name)
          }) {
            Icon(Icons.Default.Settings, contentDescription = "Settings")
          }
          IconButton(onClick = {
            navController.navigate(AppScreens.AlmanacScreen.name)
          }) {
            Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Almanac")
          }
          IconButton(onClick = {
            navController.navigate(AppScreens.SplitScreen.name)
          }) {
            Icon(Icons.Filled.DateRange, contentDescription = "Split Plan")
          }
        }
      )
    },
    modifier = modifier
  ) { innerPadding ->
    Column(modifier = Modifier.padding(innerPadding)) {
      Text("Welcome to the Main Screen!")
      // Add your main screen content here
    }
  }
}