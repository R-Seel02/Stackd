package edu.quinnipiac.ser210.stackd.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import edu.quinnipiac.ser210.stackd.Navigation.AppScreens
import edu.quinnipiac.ser210.stackd.R
import edu.quinnipiac.ser210.stackd.model.ThemeViewModel
import edu.quinnipiac.ser210.stackd.model.stackdViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplitScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    stackdViewModel: stackdViewModel,
    themeViewModel: ThemeViewModel
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        if (!themeViewModel.isDarkTheme) {
            Image(
                painter = painterResource(id = R.drawable.backgroundmain),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

        } else {
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
                            if (themeViewModel.isDarkTheme) {
                                Image(
                                    painter = painterResource(id = R.drawable.stackd_darkmode3),
                                    contentDescription = "logo",
                                    modifier = Modifier
                                        .size(100.dp)
                                        .align(Alignment.CenterVertically)
                                        .offset(x = -190.dp, y = 0.dp)
                                )
                            } else {
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
                            navController.navigate(AppScreens.AlmanacScreen.name)
                        }) {
                            Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Almanac")
                        }
                        IconButton(onClick = {
                            navController.navigate(AppScreens.MainScreen.name)
                        }) {
                            Icon(Icons.Default.Home, contentDescription = "Almanac")
                        }
                        IconButton(onClick = {
                            navController.navigate(AppScreens.SettingScreen.name)
                        }) {
                            Icon(Icons.Default.Settings, contentDescription = "Settings")
                        }
                    }
                )
            },
            containerColor = Color.Transparent,
            modifier = modifier
        ) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                Text(
                    text = "Plans",
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Italic,
                    fontSize = 25.sp,
                    modifier = modifier.offset(x = 25.dp, y = 20.dp)

                )
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    item {
                        Image(
                            painter = painterResource(id = R.drawable.split2),
                            contentDescription = "First Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .size(220.dp)
                        )
                    }

                    item {
                        Image(
                            painter = painterResource(id = R.drawable.split3),
                            contentDescription = "Second Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .size(220.dp)
                        )
                    }

                    item {
                        Image(
                            painter = painterResource(id = R.drawable.split4),
                            contentDescription = "Third Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .size(220.dp)
                        )
                    }

                    item {
                        Image(
                            painter = painterResource(id = R.drawable.split5),
                            contentDescription = "Third Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .size(220.dp)
                        )
                    }
                    item {
                        Image(
                            painter = painterResource(id = R.drawable.split6),
                            contentDescription = "Third Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .size(220.dp)
                        )
                    }
                    item {
                        Image(
                            painter = painterResource(id = R.drawable.split7),
                            contentDescription = "Third Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .size(220.dp)
                        )
                    }


                }

            }


        }
    }
    }
