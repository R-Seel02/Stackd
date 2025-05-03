package edu.quinnipiac.ser210.stackd.Screen

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star

import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import edu.quinnipiac.ser210.stackd.Navigation.AppScreens
import edu.quinnipiac.ser210.stackd.R
import edu.quinnipiac.ser210.stackd.api.Exercise
import edu.quinnipiac.ser210.stackd.api.ExerciseDropdownMenu
import edu.quinnipiac.ser210.stackd.api.groupExercisesByBodyPart
import edu.quinnipiac.ser210.stackd.model.stackdViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.ImageLoader
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.quinnipiac.ser210.stackd.model.ThemeViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun AlmanacScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    stackdViewModel: stackdViewModel,
    themeViewModel: ThemeViewModel
) {


    val darkColors = darkColorScheme()
    val lightColors = lightColorScheme()

    val filtered = stackdViewModel.filteredExercises.observeAsState(emptyList())
    var dropdownExpanded by remember { mutableStateOf(false) }
    var selectedExercise by remember { mutableStateOf<Exercise?>(null) }
    var isStarred by remember { mutableStateOf(false) }
    val favoriteExercises = stackdViewModel.getFavoritedExercises().observeAsState(emptyList())




    Box(
            modifier = Modifier.fillMaxSize()
        ) {


            if (!themeViewModel.isDarkTheme){
                Image(
                    painter = painterResource(id = R.drawable.backgroundmain),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

            }else {
                Image(
                    painter = painterResource(id = R.drawable.greyscale_background),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }




            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = "",
                                fontStyle = FontStyle.Normal
                            )
                        },
                        actions = {
                            Row {
                                if(themeViewModel.isDarkTheme){
                                    Image(
                                        painter = painterResource(id = R.drawable.stackd_darkmode3),
                                        contentDescription = "logo",
                                        modifier = Modifier
                                            .size(100.dp)
                                            .align(Alignment.CenterVertically)
                                            .offset(x=-190.dp, y = 0.dp)
                                    )
                                }else{
                                    Image(
                                        painter = painterResource(id = R.drawable.stackdlogo),
                                        contentDescription = "logo",
                                        modifier = Modifier
                                            .size(100.dp)
                                            .align(Alignment.CenterVertically)
                                            .offset(x=-190.dp, y = 0.dp)
                                    )
                                }
                            }
                            IconButton(onClick = { navController.navigate(AppScreens.SettingScreen.name) }) {
                                Icon(Icons.Default.Settings, contentDescription = "Settings")
                            }
                            IconButton(onClick = { navController.navigate(AppScreens.MainScreen.name) }) {
                                Icon(Icons.Default.Home, contentDescription = "Home")
                            }
                            IconButton(onClick = { navController.navigate(AppScreens.SplitScreen.name) }) {
                                Icon(Icons.Filled.DateRange, contentDescription = "Split Plan")
                            }
                        }
                    )
                },
                containerColor = Color.Transparent,
                modifier = modifier
            ) { innerPadding ->

                Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
                    Text(
                        text = "Welcome to the Almanac Screen",
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black,
                        fontSize = 25.sp,
                        modifier = Modifier.offset(x = 10.dp, y = 10.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))


                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(onClick = {
                            stackdViewModel.getExercisesForPart("back")
                            dropdownExpanded = true
                        }) {
                            Text("Back")
                        }

                        Button(onClick = {
                            stackdViewModel.getExercisesForPart("chest")
                            dropdownExpanded = true
                        }) {
                            Text("Chest")
                        }
                        Button(onClick = {
                            null
                        }) {
                            Text("Favorites")
                        }


                        Button(onClick = {
                            stackdViewModel.getExercisesForPart("upper legs")
                            dropdownExpanded = true
                        }) {
                            Text("Legs")
                        }
                        selectedExercise?.let { exercise ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(top = 8.dp)
                            ) {
                                Text(exercise.name, fontWeight = FontWeight.Bold)
                                Spacer(modifier = Modifier.width(8.dp))
                                IconButton(onClick = {
//                                    stackdViewModel.toggleFavorite(exercise)
                                }) {
                                    Icon(
                                        imageVector = if (exercise.isFavorited) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                        contentDescription = if (exercise.isFavorited) "Unfavorite" else "Favorite"
                                    )
                                }
                            }
                        }



                    }
                    Row(modifier = Modifier) {
                        Button(onClick = {
                            stackdViewModel.getExercisesForPart("lower legs")
                            dropdownExpanded = true
                            modifier
                                .offset(x = 0.dp, y = 2000.dp)
                        }) {
                            Text("Lower Legs")
                        }

                        Button(onClick = {
                            stackdViewModel.getExercisesForPart("shoulders")
                            dropdownExpanded = true
                            modifier
                                .offset(x = 0.dp, y = 2000.dp)
                        }) {
                            Text("Shoulders")
                        }

                    }

                    Spacer(modifier = Modifier.height(10.dp))


                    Box {
                        Button(onClick = { dropdownExpanded = true }) {
                            Text(selectedExercise?.name ?: "Select Exercise")
                        }

                        DropdownMenu(
                            expanded = dropdownExpanded,
                            onDismissRequest = { dropdownExpanded = false }
                        ) {
                            filtered.value.forEach { exercise ->
                                DropdownMenuItem(
                                    text = { Text(exercise.name) },
                                    onClick = {
                                        selectedExercise = exercise
                                        dropdownExpanded = false
                                    }
                                )
                            }
                        }
                    }
                    val context = LocalContext.current
                    val imageLoader = ImageLoader.Builder(context)
                        .components {
                            add(GifDecoder.Factory())
                        }
                        .build()

                    selectedExercise?.let { exercise ->
                        Column {

                            Spacer(modifier = Modifier.height(16.dp))
                            Text("Target: ${exercise.target ?: "Unknown"}", color = Color.Black)
                            Text(
                                "Equipment: ${exercise.equipment ?: "Unknown"}",
                                color = Color.Black
                            )


                            Spacer(modifier = Modifier.height(8.dp))


                            exercise.gifUrl?.let { gif ->
                                AsyncImage(
                                    model = gif,
                                    contentDescription = "${exercise.name} animation",
                                    imageLoader = imageLoader,
                                    modifier = Modifier
                                        .height(250.dp)
                                        .fillMaxWidth()
                                        .padding(vertical = 8.dp),
                                    contentScale = ContentScale.Fit
                                )

                            }
                            IconButton(
                                onClick = {    selectedExercise?.let {
                                    stackdViewModel.toggleFavorite(it)
                                    selectedExercise = it.copy(isFavorited = !it.isFavorited)
                                } },
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            ) {
                                Icon(
                                    imageVector = if (selectedExercise?.isFavorited == true) Icons.Default.Star else Icons.Outlined.Star,
                                    contentDescription = if (selectedExercise?.isFavorited == true) "Starred" else "Not Starred",
                                    tint = if (selectedExercise?.isFavorited == true) Color(0xFFFFD700) else Color.Gray
                                )
                            }


                        }
                    }
                }
            }
        }
    }




