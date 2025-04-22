package edu.quinnipiac.ser210.stackd.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.quinnipiac.ser210.stackd.Navigation.AppScreens
import edu.quinnipiac.ser210.stackd.model.stackdViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController : NavController, stackdViewModel : stackdViewModel, modifier: Modifier
)
{
  val exerciseResult = stackdViewModel.exerciseResult.observeAsState()
   // val exerciseResult = stackdViewModel.exerciseResult.observeAsState()
    val workoutsList = exerciseResult.value?.body()
    val workoutsListNonNullable = workoutsList?.filterNotNull() ?: emptyList()

    Column(modifier = Modifier.padding(12.dp)) {


    }
}

