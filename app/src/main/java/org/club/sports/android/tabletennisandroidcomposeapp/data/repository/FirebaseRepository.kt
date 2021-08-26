package org.club.sports.android.tabletennisandroidcomposeapp.data.repository

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import kotlinx.coroutines.tasks.await
import org.club.sports.android.tabletennisandroidcomposeapp.data.model.Player
import org.club.sports.android.tabletennisandroidcomposeapp.data.model.Player.Companion.toPlayer

const val COLLECTION_PLAYERS = "players"
const val TAG = "FirebaseRepository"

class FirebaseRepository {

    // Firebase - Firestore Setting
    private val db = FirebaseFirestore.getInstance()

    // Firebase - Emulator Setting
    private val settings = FirebaseFirestoreSettings.Builder()
        .setHost("10.0.2.2:8080")
        .setSslEnabled(false)
        .setPersistenceEnabled(false)
        .build()


    suspend fun getPlayersOrderByTotalScoreDesc(): List<Player> {
        // firebase will use the emulator
        // remove this once ready for production
        db.firestoreSettings = settings

        return try {
            db.collection(COLLECTION_PLAYERS)
                .get()
                .await()
                .documents
                .mapNotNull { it.toPlayer() }
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching players.", e)
            emptyList()
        }
    }

    suspend fun savePlayer(player: Player) {
        val db = FirebaseFirestore.getInstance()
        db.collection(COLLECTION_PLAYERS)
            .add(player)
            .addOnSuccessListener {
                Log.d(TAG, "New player inserted ${it.id}).")
            }
            .addOnFailureListener {
                Log.e(TAG, "Error inserting player.", it)
            }
    }
}