package com.nudennie.interviewprepapp.db;

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [QuizInfo::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class QuizDatabase : RoomDatabase() {
    // To get access to Dao and its functions
    abstract fun getQuizDao(): QuizDao

    // For implementing the singleton concept for database instance we use companion object
    companion object {
        @Volatile
        private var INSTANCE: QuizDatabase? = null
        fun getDatabaseInstance(context: Context): QuizDatabase? {
            if (INSTANCE != null) return INSTANCE
            // To make sure only one thread can access this at a time
            synchronized(this) {
                // Building the database instance, will only be called once
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuizDatabase::class.java,
                    "QuizTable"
                ).build()
                INSTANCE = instance
                return INSTANCE
            }
        }
    }
}
