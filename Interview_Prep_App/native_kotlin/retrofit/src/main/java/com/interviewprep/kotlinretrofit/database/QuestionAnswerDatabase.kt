package com.interviewprep.kotlinretrofit.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [QuestionEntity::class], version = 1)
abstract class QuestionAnswerDatabase : RoomDatabase() {
    abstract fun questionsDao(): QuestionsDao
}
