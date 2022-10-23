package com.interviewprep.kotlinretrofit.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questionAnswer")
data class QuestionAnswerEntity(
    @PrimaryKey val question_id: Int,
    @ColumnInfo(name = "question_type") val questionType: String,
    @ColumnInfo(name = "question") val question: String,
    @ColumnInfo(name = "details") val details: String,
    @ColumnInfo(name = "short_answer") val shortAns: String,
    @ColumnInfo(name = "true_or_false") val trueOrFalse: String?,
    @ColumnInfo(name = "answer") val answer: String?,
    @ColumnInfo(name = "answer_details") val answerDetails: String?
)