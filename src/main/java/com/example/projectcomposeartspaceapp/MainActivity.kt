package com.example.projectcomposeartspaceapp


import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projectcomposeartspaceapp.ui.theme.ProjectComposeArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectComposeArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier,
             horizontalAlignment: Alignment = Alignment.Center
             ){
    val adoration2 = R.drawable.adoration
    val atumn3 = R.drawable.atumn_image
    val robert4 = R.drawable.robert_image
    val summer5 = R.drawable.summer_image
    val starry1 = R.drawable.the_starry_night
    val winter6 = R.drawable.winter_image
    var currentArt by remember{ mutableStateOf(starry1) }
    var year by remember{ mutableStateOf(R.string.YearOfArtStarry) }
    var title by remember{ mutableStateOf(R.string.NameOfArtStarry) }
    var artist by remember{ mutableStateOf(R.string.ArtistNameOfArtStarry) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.Center

    ){
        Art(currentArt = currentArt)
        Spacer(modifier = Modifier.padding(30.dp))
        textRes(artName = title, artYear = year, artistName = artist)
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
        ) {
            Button(
                onClick =
            {
              when (currentArt){
                  starry1 -> {
                      currentArt = winter6
                      title = R.string.NameOfArtWind
                      year = R.string.YearOfArtWind
                  }
                  adoration2 -> {
                      currentArt = starry1
                      title = R.string.NameOfArtStarry
                      year = R.string.YearOfArtStarry
                      artist = R.string.ArtistNameOfArtStarry
                  }
                  atumn3 -> {
                      currentArt = adoration2
                      title = R.string.NameOfArtAdoration
                      year = R.string.YearOfArtAdoration
                      artist = R.string.ArtistNameOfArtAdoration
                  }
                  robert4 -> {
                      currentArt = atumn3
                      title = R.string.NameOfArtRobert
                      year = R.string.YearOfArtRobert
                      artist = R.string.ArtistNameRobert
                  }
                  summer5 -> {
                      currentArt = robert4
                      title  = R.string.NameOfArtSummer
                      year =R.string.YearOfArtSummer
                  }
                  else -> {
                      currentArt = winter6
                      title = R.string.NameOfArtWind
                      year = R.string.YearOfArtWind
                  }
              }
            }
            ) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.padding(80.dp))
            Button(onClick =
            {
                when (currentArt){
                    starry1 -> {
                        currentArt = adoration2
                        title = R.string.NameOfArtAdoration
                        year = R.string.YearOfArtAdoration
                        artist = R.string.ArtistNameOfArtAdoration
                    }
                    adoration2 -> {
                        currentArt = atumn3
                        title = R.string.NameOfArtAutumn
                        year = R.string.YearOfArtAutumn
                    }
                    atumn3 -> {
                        currentArt = robert4
                        title = R.string.NameOfArtRobert
                        year = R.string.YearOfArtRobert
                        artist = R.string.ArtistNameRobert
                    }
                    robert4 -> {
                        currentArt = summer5
                        title = R.string.NameOfArtSummer
                        year = R.string.YearOfArtSummer
                    }
                    summer5 -> {
                        currentArt = winter6
                        title  = R.string.NameOfArtWind
                        year =R.string.YearOfArtWind
                    }
                    else -> {
                        currentArt = starry1
                        title = R.string.NameOfArtStarry
                        year = R.string.YearOfArtStarry
                        artist = R.string.ArtistNameOfArtStarry
                    }
                }
            }
            ) {
                Text(
                    text = "Next"
                )

            }

        }
    }
}

@Composable
fun textRes(
    @StringRes artName :Int,
    @StringRes artYear :Int,
    @StringRes artistName :Int
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
            ){
        Text(
            stringResource(id = artName)
        )
        Row(){
          Text(
              stringResource(id = artistName)
          )
          Text(
              stringResource(id = artYear)
          )
        }
    }
}


@Composable
fun Art(
    modifier: Modifier = Modifier, 
    @DrawableRes currentArt: Int
){
    Image(
        painter = painterResource(currentArt),
        contentDescription = stringResource(id = R.string.NameOfArtStarry)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpace()
}