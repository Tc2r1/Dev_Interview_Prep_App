package com.interviewprep.kotlinretrofit.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.interviewprep.kotlinretrofit.repository.models.Question

@Database(entities = [QuestionAnswerEntity::class], version = 1)
abstract class QuestionAnswerDatabase: RoomDatabase() {
    abstract fun questionAnswerDao(): QuestionAnswerDao
}