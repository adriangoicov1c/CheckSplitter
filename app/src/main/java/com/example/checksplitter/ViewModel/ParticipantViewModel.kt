package com.example.checksplitter.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.checksplitter.Model.Participant
import com.example.checksplitter.Repository.ParticipantRepository
import com.example.checksplitter.Room.ParticipantDatabase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class ParticipantViewModel (application: Application) : AndroidViewModel(application) {
    private val repository: ParticipantRepository
    val strings: Flow<List<Participant>>

    init {
        val participantDao = ParticipantDatabase.getDatabase(application).ParticipantDao()
        repository = ParticipantRepository(participantDao)
        strings = repository.allStrings
    }

    fun addString(value: String) = viewModelScope.launch {
        repository.insert(Participant(name = value))
    }

    fun updateString(index: Int, newValue: String) = viewModelScope.launch {
        val currentList = repository.allStrings.first()
        val stringEntity = currentList[index].copy(name = newValue)
        repository.update(stringEntity)
    }

    fun removeString(index: Int) = viewModelScope.launch {
        val currentList = repository.allStrings.first()
        val stringEntity = currentList[index]
        repository.delete(stringEntity)
    }


}