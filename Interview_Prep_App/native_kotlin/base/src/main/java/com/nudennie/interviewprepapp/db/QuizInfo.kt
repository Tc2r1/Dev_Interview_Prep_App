package com.nudennie.interviewprepapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nudennie.interviewprepapp.repositories.models.response.Answer
import com.nudennie.interviewprepapp.repositories.models.response.Question

// Data class for each row in the QuizTable
@Entity(tableName = "QuizTable")
data class QuizInfo(
    @PrimaryKey(autoGenerate = true) val qid: Int,
    @ColumnInfo(name = "Question") val question: Question?,
    @ColumnInfo(name = "Answer") val answer: Answer?
)
