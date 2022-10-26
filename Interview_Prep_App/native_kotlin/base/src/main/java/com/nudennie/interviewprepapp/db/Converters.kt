package com.nudennie.interviewprepapp.db

import androidx.room.TypeConverter
import com.nudennie.interviewprepapp.repositories.models.response.Answer
import com.nudennie.interviewprepapp.repositories.models.response.Question

class Converters {
    // To convert the Question class object to a string to be stored in the room table
    @TypeConverter
    fun fromQuestion(value: Question): String {
        return value.question
    }

    @TypeConverter
    fun toQuestion(value: String): Question {
        return Question.Builder(1, "", question = value, "").build()
    }


    //to convert the Answer class object to string to be stored in the room table
    @TypeConverter
    fun fromAnswer(value: Answer): String? {
        return value.answer
    }

    @TypeConverter
    fun toAnswer(value: String): Answer {
        return Answer(value)
    }
}