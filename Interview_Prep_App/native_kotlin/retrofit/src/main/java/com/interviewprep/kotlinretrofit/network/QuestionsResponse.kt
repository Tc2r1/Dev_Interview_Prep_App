package com.interviewprep.kotlinretrofit.network

import com.interviewprep.kotlinretrofit.models.Question
import com.google.gson.annotations.SerializedName

data class QuestionsResponse(
    @SerializedName("questions")
    var questions: ArrayList<Question>
)
