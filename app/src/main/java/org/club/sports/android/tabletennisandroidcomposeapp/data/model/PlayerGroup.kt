package org.club.sports.android.tabletennisandroidcomposeapp.data.model


data class PlayerGroup(
    var id: String? = null,
    var name: String? = null,
    var description: String? = null,
    var rules: List<String>? = listOf()
)
