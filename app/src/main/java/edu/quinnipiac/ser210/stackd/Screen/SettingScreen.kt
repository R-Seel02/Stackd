package edu.quinnipiac.ser210.stackd.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
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
import edu.quinnipiac.ser210.stackd.model.ThemeViewModel
import edu.quinnipiac.ser210.stackd.model.stackdViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(
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
                    text = "Settings",
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Italic,
                    fontSize = 25.sp,
                    modifier = modifier.offset(x = 25.dp,y=20.dp)

                )
                Row(
                    modifier = Modifier.fillMaxWidth().offset(x=25.dp,y=45.dp),
                    horizontalArrangement = Arrangement.spacedBy(240.dp)

                ) {
                    Text(
                        text = if (themeViewModel.isDarkTheme) "Dark Mode" else "Light Mode",
                        style = MaterialTheme.typography.bodyLarge


                    )

                    Switch(
                        checked = themeViewModel.isDarkTheme,
                        onCheckedChange = { themeViewModel.toggleTheme() }
                    )
                }

            }
        }
    }
}
