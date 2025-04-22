package edu.quinnipiac.ser210.stackd.Screen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import edu.quinnipiac.ser210.stackd.model.stackdViewModel


@Composable
fun SettingScreen(
    modifier: Modifier,
    navController: NavHostController,
    stackdViewModel: stackdViewModel
) {
    Text(text = "Welcome to Setting Screen")
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StackdAppBar(){
    TopAppBar(
        title = {Text("Stackd")}
    )


}
