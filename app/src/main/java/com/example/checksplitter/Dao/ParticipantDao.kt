package com.example.checksplitter.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.checksplitter.Model.Participant
import kotlinx.coroutines.flow.Flow

@Dao
interface ParticipantDao {
    @Query("SELECT * FROM participant")
    fun getAllParticipants(): Flow<List<Participant>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertParticipant(participant: Participant)

    @Update
    fun updateParticipant(participant: Participant)

    @Delete
    fun deleteParticipant(participant: Participant)
}