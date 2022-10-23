package com.interviewprep.kotlinretrofit.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuestionAnswerDao {

    @Insert
    fun insertQuestionAnswer(questionAnswerEntity: QuestionAnswerEntity)

    @Delete
    fun deleteQuestionAnswer(questionAnswerEntity: QuestionAnswerEntity)

    @Query("SELECT * FROM questionAnswer WHERE question_id = :questionId")
    fun getQuestionAnswerById(questionId: Int): QuestionAnswerEntity

    @Query("SELECT * FROM questionAnswer")
    fun getAllQuestionAnswer(): List<QuestionAnswerEntity>
}