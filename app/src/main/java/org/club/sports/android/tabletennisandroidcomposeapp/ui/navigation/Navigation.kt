package org.club.sports.android.tabletennisandroidcomposeapp.ui.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import org.club.sports.android.tabletennisandroidcomposeapp.R
import org.club.sports.android.tabletennisandroidcomposeapp.data.model.Player
import org.club.sports.android.tabletennisandroidcomposeapp.data.viewmodel.PlayerViewModel
import org.club.sports.android.tabletennisandroidcomposeapp.ui.components.account.AccountView
import org.club.sports.android.tabletennisandroidcomposeapp.ui.components.leaderboard.LeaderboardView
import org.club.sports.android.tabletennisandroidcomposeapp.ui.components.rules.RuleView

@Composable
fun Navigation(playerViewModel: PlayerViewModel, navController: NavHostController) {
    val leaderboard: List<Player> by playerViewModel.players.observeAsState(listOf())

    NavHost(
        navController = navController,
        startDestination = NavigationItem.Leaderboard.route
    ) {
        composable(NavigationItem.Leaderboard.route) {
            LeaderboardView(leaderboard)
        }

        composable(NavigationItem.Account.route) {
            AccountView()
        }

        composable(NavigationItem.Scoring.route) {
            RuleView()
        }
    }
}