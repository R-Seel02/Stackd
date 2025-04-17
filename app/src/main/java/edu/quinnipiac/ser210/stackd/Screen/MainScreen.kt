package edu.quinnipiac.ser210.stackd.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.quinnipiac.ser210.stackd.model.StackdViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController : NavController, stackdViewModel : StackdViewModel
)
{
    val exerciseResult = StackdViewModel.exerciseResult.observeAsState()
    val heroList = exerciseResult.value?.body()
    val heroListNonNullable = heroList?.filterNotNull() ?: emptyList()

    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(heroListNonNullable) {
                //add movieRow here
                HeroRow(hero = it){ hero->
                    navController.navigate(route = AppScreens.DetailScreen.name+"/$hero")
                }
            }
        }
    }
}

@Composable
fun HeroRow(hero: Hero,itemClick: (String)-> Unit = {} ) {

    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxSize()
        .clickable {
            //add itemclick
            itemClick(hero.name)
        },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),) {
        Column() {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .height(180.dp),
                shape = RectangleShape,
            ) {
                Image(
                    painter = rememberImagePainter(data = hero.imageurl),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Movie Poster"
                )


            }

            Text(
                text = hero.name,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start=10.dp)
            )
            Text(
                text = "Real name: ${hero.realname}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start=10.dp)
            )
            Text(
                text = "First Appearance: ${hero.firstappearance}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start=10.dp)
            )

        }



    }


}