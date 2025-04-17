package edu.quinnipiac.ser210.stackd.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
//import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
//import coil.compose.rememberImagePainter
import edu.quinnipiac.ser210.stackd.Navigation.AppScreens
//import edu.quinnipiac.ser210.stackd.model.Exercise


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
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MainScreen(
//    navController: NavController,
//    stackdViewModel: StackdViewModel
//) {
//    val exerciseResult = stackdViewModel.exerciseResult.observeAsState()
//    val exerciseList = exerciseResult.value?.body() ?: emptyList()
//
//    Column(modifier = Modifier.padding(12.dp)) {
//        LazyColumn {
//            items(exerciseList.size) { index ->
//                ExerciseRow(exercise = exerciseList[index]) { exerciseName ->
//                    navController.navigate(route = AppScreens.Mainscreen.name + "/$exerciseName")
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun ExerciseRow(exercise: Exercise, itemClick: (String) -> Unit = {}) {
//    Card(
//        modifier = Modifier
//            .padding(4.dp)
//            .fillMaxSize(),
//        shape = RoundedCornerShape(corner = CornerSize(16.dp))
//    ) {
//        Column {
//            Surface(
//                modifier = Modifier
//                    .padding(12.dp)
//                    .fillMaxWidth()
//                    .height(180.dp),
//                shape = RoundedCornerShape(16.dp)
//            ) {
//                Image(
//                    painter = rememberImagePainter(data = exercise.imageUrl),
//                    contentScale = ContentScale.Crop,
//                    contentDescription = "Exercise Image"
//                )
//            }
//
//            Text(
//                text = exercise.name,
//                style = MaterialTheme.typography.titleLarge,
//                modifier = Modifier.padding(start = 10.dp)
//            )
//            Text(
//                text = "Description: ${exercise.description}",
//                style = MaterialTheme.typography.bodyLarge,
//                modifier = Modifier.padding(start = 10.dp)
//            )
//        }
//    }
//}