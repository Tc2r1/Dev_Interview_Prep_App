package com.nudennie.interviewprepapp.db

import androidx.room.TypeConverter
import com.nudennie.interviewprepapp.repositories.models.response.Answer
import com.nudennie.interviewprepapp.repositories.models.response.Question

class Converters {
    // To convert the Question class object to a string to be stored in the room table
    @TypeConverter
    fun questionToString(value: Question): String {
        return value.question;
    }

    //to convert the Answer class object to string to be stored in the room table
    @TypeConverter
    fun answerToString(value: Answer): String? {
        return value.answer
    }
}