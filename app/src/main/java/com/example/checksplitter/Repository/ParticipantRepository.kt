package com.example.checksplitter.Repository

import androidx.annotation.WorkerThread
import com.example.checksplitter.Dao.ParticipantDao
import com.example.checksplitter.Model.Participant
import kotlinx.coroutines.flow.Flow

class ParticipantRepository (private val participantDao: ParticipantDao) {
    val allStrings: Flow<List<Participant>> = participantDao.getAllParticipants()

    @WorkerThread
    suspend fun insert(string: Participant) {
        participantDao.insertParticipant(string)
    }

    @WorkerThread
    suspend fun update(string: Participant) {
        participantDao.updateParticipant(string)
    }

    @WorkerThread
    suspend fun delete(string: Participant) {
        participantDao.deleteParticipant(string)
    }
}