package com.dreams.androidquizapp.network

import com.dreams.androidquizapp.models.Question
import com.google.gson.annotations.SerializedName

data class QuestionsResponse(
    @SerializedName("questions")
    var questions: ArrayList<Question>
)