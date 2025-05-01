package edu.quinnipiac.ser210.stackd.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
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
                    .offset(x = -190.dp, y = 0.dp)
                )
              }else{
                Image(
                  painter = painterResource(id = R.drawable.stackdlogo),
                  contentDescription = "logo",
                  modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterVertically)
                    .offset(x = -190.dp, y = 0.dp)
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
      Column(modifier = Modifier
        .padding(innerPadding)
        .fillMaxSize()) {

        Text(
          text = "Welcome to Stackd <Name>",
          color = Color.Black,
          fontStyle = FontStyle.Italic,
          fontFamily = FontFamily.SansSerif,
          fontSize = 28.sp,
          modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(top = 24.dp)
        )

        HorizontalDivider(
          modifier = Modifier.padding(vertical = 12.dp, horizontal = 24.dp),
          thickness = 1.dp,
          color = Color.DarkGray
        )

        Text(
          text = "Spotlight on these Workouts :)",
          fontSize = 22.sp,
          fontStyle = FontStyle.Italic,
          fontFamily = FontFamily.SansSerif,
          modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(vertical = 12.dp)
        )

        Divider(
          color = Color.LightGray,
          thickness = 1.dp,
          modifier = Modifier.padding(horizontal = 24.dp)
        )

        LaunchedEffect(Unit) {
          stackdViewModel.getRandomExercises()
        }

        val response = stackdViewModel.exerciseResult.observeAsState()
        val exercises = response.value?.body()?.shuffled()?.take(3) ?: emptyList()

        Text(
          text = "Workout of the Week",
          color = Color.Black,
          fontSize = 20.sp,
          fontWeight = FontWeight.Bold,
          fontFamily = FontFamily.Serif,
          modifier = Modifier.padding(start = 24.dp, top = 16.dp, bottom = 8.dp)
        )

        exercises.forEach { exercise ->
          Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)) {

            Text(
              text = exercise.name?.replaceFirstChar { it.uppercase() } ?: "Unnamed Exercise",
              fontSize = 18.sp,
              fontWeight = FontWeight.Medium
            )

            Text(
              text = "🎯 Target: ${exercise.target ?: "?"}",
              fontSize = 14.sp,
              color = Color.DarkGray
            )

            Text(
              text = "🏋️ Equipment: ${exercise.equipment ?: "?"}",
              fontSize = 14.sp,
              color = Color.DarkGray
            )

            HorizontalDivider(
              modifier = Modifier.padding(top = 12.dp, bottom = 6.dp),
              thickness = 0.7.dp,
              color = Color.LightGray
            )










          }
        }
        Row(verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier
            .fillMaxWidth()
            .testTag("recommendedSplitsRow")
            .padding(horizontal = 24.dp, vertical = 12.dp))



        {
          Column {
            Text(
              text = "Recommended Splits",
              fontSize = 22.sp,
              fontStyle = FontStyle.Italic,
              fontFamily = FontFamily.SansSerif,
              modifier = Modifier
                .padding(vertical = 12.dp)
                .testTag("splitsText")
            )


          }
          Icon(Icons.Default.ArrowDropDown, contentDescription = null, modifier = Modifier.testTag("splitsArrow"))


          }

        Image(painter = painterResource(id = R.drawable.split1), contentDescription = null, modifier = Modifier.align(Alignment.CenterHorizontally))


      }












        }

      }
    }


