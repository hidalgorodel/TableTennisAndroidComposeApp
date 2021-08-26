package org.club.sports.android.tabletennisandroidcomposeapp.data.model

import com.google.firebase.firestore.ServerTimestamp
import java.sql.Timestamp

data class Rule(
    var id: String? = null,
    var minLimit: Int = 0,
    var maxLimit: Int = 0,
    var offsetValue: Int = 0,
    var value: Int = 0,
    @ServerTimestamp
    var timestamp: Timestamp
)
