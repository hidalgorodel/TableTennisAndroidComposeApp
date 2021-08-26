package org.club.sports.android.tabletennisandroidcomposeapp.data.model

import android.os.Parcelable
import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    var id: String? = null,
    var lastname: String? = null,
    var firstname: String? = null,
    var email: String? = null,
    var phoneNumber: Int? = 0,
    var groups: List<String>? = listOf(),
    var groupRole: String? = null,
    var scores: List<String>? = listOf(),
    var totalScore: Int = 0
) : Parcelable {
    companion object {
        fun DocumentSnapshot.toPlayer(): Player {
            val lastname = getString("lastname")!!
            val firstname = getString("firstname")!!
            val email = getString("email")
            val phoneNumber = get("phone_number")
            val groups = get("groups")
            val groupRole = getString("group_role")
            val scores = get("scores")
            val totalScore = get("total_score")

            return Player(
                id, lastname, firstname, email,
                phoneNumber as Int?, groups as List<String>?, groupRole,
                scores as List<String>?, totalScore as Int
            )
        }
    }
}
