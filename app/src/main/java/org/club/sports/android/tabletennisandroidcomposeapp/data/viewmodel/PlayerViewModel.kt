package org.club.sports.android.tabletennisandroidcomposeapp.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.club.sports.android.tabletennisandroidcomposeapp.data.model.Player
import org.club.sports.android.tabletennisandroidcomposeapp.data.repository.FirebaseRepository

class PlayerViewModel: ViewModel() {

    private val _players = MutableLiveData<List<Player>>()
    val players: LiveData<List<Player>> = _players

    private val _player = MutableLiveData<Player>()
    val player: LiveData<Player> = _player

    init {
        getLeaderboards()
    }

    fun addPlayer(player: Player) {
        viewModelScope.launch {
            FirebaseRepository().savePlayer(player)
            getLeaderboards()
        }
    }

    private fun getLeaderboards() {
        viewModelScope.launch {
            _players.value = FirebaseRepository().getPlayersOrderByTotalScoreDesc()
        }
    }
}