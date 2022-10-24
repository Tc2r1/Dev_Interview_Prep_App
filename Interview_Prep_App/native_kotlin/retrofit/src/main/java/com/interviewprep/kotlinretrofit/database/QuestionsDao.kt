package com.interviewprep.kotlinretrofit.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert

@Dao
interface QuestionsDao {

    @Insert
    fun insertQuestionAnswer(questionEntity: QuestionEntity)

    @Delete
    fun deleteQuestionAnswer(questionEntity: QuestionEntity)
    //
    //@Query("SELECT * FROM questionAnswer WHERE question_id = :questionId")
    //fun getQuestionAnswerById(questionId: Int): QuestionEntity
    //
    //@Query("SELECT * FROM questions")
    //fun getAllQuestions(): ArrayList<Question>
}
