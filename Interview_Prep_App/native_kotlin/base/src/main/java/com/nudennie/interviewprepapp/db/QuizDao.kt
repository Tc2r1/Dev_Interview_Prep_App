package com.nudennie.interviewprepapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query

@Dao
interface QuizDao {
    // Function to get all Questions and Answers from a table
    @Query("SELECT * FROM QuizTable")
    fun getAll(): List<QuizInfo>

    // Function to delete all Questions and Answers in the table
    @Query("DROP TABLE QuizTable")
    fun deleteQuiz()

    //Function to delete a particular note
    @Delete
    suspend fun deleteNote(quizInfo: QuizInfo)
}