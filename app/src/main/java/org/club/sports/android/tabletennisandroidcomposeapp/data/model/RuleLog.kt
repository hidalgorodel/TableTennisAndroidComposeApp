package org.club.sports.android.tabletennisandroidcomposeapp.data.model

import com.google.firebase.firestore.ServerTimestamp
import java.sql.Timestamp

data class RuleLog(
    var id: String? = null,
    var rule: Rule,
    var modifiedBy: String? = null,
    @ServerTimestamp
    var timestamp: Timestamp
)
