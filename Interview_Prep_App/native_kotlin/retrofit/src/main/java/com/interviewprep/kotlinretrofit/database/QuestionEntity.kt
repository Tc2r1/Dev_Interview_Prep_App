package com.interviewprep.kotlinretrofit.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Immutable model class for a Task. In order to compile with Room, we can't use @JvmOverloads to
 * generate multiple constructors.
 *
 * @param question_id primary key, id of a question
 * @param questionType true or false, or multiple choice
 * @param question This is what will be asked for the user
 * @param shortAns This is the correct answer to the question. It will be mixed with
 * 3 incorrect answer and presented to user
 * @param details This is more indepth knowledge on the topic
 * @param trueOrFalse This will be either true or false if questionType is bool
 */
@Entity(tableName = "QuizQuestions")
data class QuestionEntity(
    @PrimaryKey val question_id: Int,
    @ColumnInfo(name = "question_type") val questionType: String,
    @ColumnInfo(name = "question") val question: String,
    @ColumnInfo(name = "details") val details: String,
    @ColumnInfo(name = "short_answer") val shortAns: String,
    @ColumnInfo(name = "true_or_false") val trueOrFalse: String?
) {
    val isBoolean: Boolean
        get() = questionType == "bool"
}
