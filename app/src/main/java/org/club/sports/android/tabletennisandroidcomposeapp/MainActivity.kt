package org.club.sports.android.tabletennisandroidcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import org.club.sports.android.tabletennisandroidcomposeapp.data.viewmodel.PlayerViewModel
import org.club.sports.android.tabletennisandroidcomposeapp.ui.navigation.BottomNavigationBar
import org.club.sports.android.tabletennisandroidcomposeapp.ui.navigation.Navigation
import org.club.sports.android.tabletennisandroidcomposeapp.ui.theme.TableTennisAndroidComposeAppTheme

class MainActivity : ComponentActivity() {

    private val playerViewModel by viewModels<PlayerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TableTennisAndroidComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.primary) {
                    MainScreen(playerViewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen(playerViewModel: PlayerViewModel) {
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopAppBar() },
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Navigation(playerViewModel, navController)
    }
}

@Composable
fun TopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "Table Tennis Scoring Manager",
                style = MaterialTheme.typography.body1
            )
        },
        backgroundColor = colorResource(id = R.color.white),
        contentColor = Color.Black
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TableTennisAndroidComposeAppTheme {
        //MainScreen(playerViewModel)
    }
}