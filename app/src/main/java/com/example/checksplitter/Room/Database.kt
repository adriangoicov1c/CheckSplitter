package com.example.checksplitter.Room

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.checksplitter.Dao.ParticipantDao
import com.example.checksplitter.Model.Participant


@Database(entities = [Participant::class], version = 1, exportSchema = false)

abstract class ParticipantDatabase :RoomDatabase(){

    abstract fun ParticipantDao(): ParticipantDao

    companion object {
        @Volatile
        private var INSTANCE: ParticipantDatabase? = null

        fun getDatabase(context: Context): ParticipantDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ParticipantDatabase::class.java,
                    "string_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }
    
}