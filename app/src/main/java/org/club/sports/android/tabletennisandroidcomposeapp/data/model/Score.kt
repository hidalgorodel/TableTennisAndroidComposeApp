package org.club.sports.android.tabletennisandroidcomposeapp.data.model

import com.google.firebase.firestore.ServerTimestamp
import java.sql.Timestamp

data class Score(
    var id: String? = null,
    var playerId: String? = null,
    var playerCurrentScore: Int = 0,
    var opponentId: String? = null,
    var opponentCurrentScore: Int = 0,
    var value: Int = 0,
    var status: String? = null,
    var ruleId: String? = null,
    @ServerTimestamp
    var timestamp: Timestamp
)
