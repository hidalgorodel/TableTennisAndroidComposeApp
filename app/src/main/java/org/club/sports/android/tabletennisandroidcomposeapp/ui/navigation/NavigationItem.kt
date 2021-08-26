package org.club.sports.android.tabletennisandroidcomposeapp.ui.navigation

import org.club.sports.android.tabletennisandroidcomposeapp.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Leaderboard: NavigationItem(route = "leaderboard", icon = R.drawable.icon_leaderboard, title = "Leaderboard")
    object Account: NavigationItem(route = "account", icon = R.drawable.ic_baseline_account_circle_24 , title = "Account")
    object Scoring: NavigationItem(route = "scoring", icon = R.drawable.ic_round_score_24, title = "Scoring")
}
