package com.interviewprep.kotlinretrofit.network

import com.google.gson.annotations.SerializedName
import com.interviewprep.kotlinretrofit.models.Question

data class QuestionsResponse(
    @SerializedName("questions")
    var questions: ArrayList<Question>
)
