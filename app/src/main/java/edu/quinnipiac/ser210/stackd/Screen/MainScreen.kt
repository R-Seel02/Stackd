package edu.quinnipiac.ser210.stackd.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import edu.quinnipiac.ser210.stackd.Navigation.AppScreens
import edu.quinnipiac.ser210.stackd.R
import edu.quinnipiac.ser210.stackd.api.Exercise
import edu.quinnipiac.ser210.stackd.api.randomExercies
import edu.quinnipiac.ser210.stackd.model.ThemeViewModel
import edu.quinnipiac.ser210.stackd.model.stackdViewModel
import java.time.LocalDateTime
import androidx.compose.material3.DropdownMenu
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import java.time.format.DateTimeFormatter


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun MainScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    stackdViewModel: stackdViewModel,
    themeViewModel: ThemeViewModel

) {


  Box(
    modifier = Modifier
      .fillMaxSize()
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
      containerColor = Color.Transparent,
      modifier = modifier
    ) { innerPadding ->
      Column(modifier = Modifier.padding(innerPadding)) {
        Text(
          text = "Welcome to Stackd <Name>",
          color = Color.Black,
          fontFamily = FontFamily.SansSerif,
          fontSize = 30.sp,
          modifier = modifier
            .align(Alignment.CenterHorizontally)
            .padding(20.dp),
        )

//        val dateSt = "2025-04-29T21:30:40Z"
//        val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
//        val formattedDate = LocalDateTime.parse(dateSt, dateFormatter)
//        val res = DateTimeFormatter.ofPattern("MMMM dd, yyyy | hh:mma").format(formattedDate) // August 04, 2017 | 6:39pm




        Text(
          text =  "Spotlight on these \n \nWorkouts :)",
          fontSize = 30.sp,
          fontStyle = FontStyle.Normal,
          fontFamily = FontFamily.SansSerif,
          modifier = Modifier.
          align(Alignment.CenterHorizontally)
            .padding(70.dp)
        )




        LaunchedEffect(Unit) {
          stackdViewModel.getRandomExercises()
          }

        val response = stackdViewModel.exerciseResult.observeAsState()
        val exerciseList = response.value?.body() ?: emptyList()

        val exercises = stackdViewModel.exerciseResult.value?.body() ?: emptyList()



        Text(
          text = "WTW 1: ",
          color = Color.Black,
          fontSize = 20.sp,
          fontStyle = FontStyle.Normal,
          fontFamily = FontFamily.Serif,
          modifier = Modifier.padding(10.dp)
            .offset(x = 30.dp, y = -70.dp)
        )


        exercises.take(3).forEach { exercise ->
          Text(text = exercise.name ?: "Unknown", fontSize = 18.sp)
          Text(text = "Target: ${exercise.target ?: "?"}")
          Text(text = "Equipment: ${exercise.equipment ?: "?"}")
          Spacer(modifier = Modifier.height(12.dp).offset(x=90.dp,y=-35.dp))

        }



        }

      }
    }
  }

