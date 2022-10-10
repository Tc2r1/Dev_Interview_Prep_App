package com.interviewprep.kotlinretrofit.repository.models.response

import com.google.gson.annotations.SerializedName
import com.interviewprep.kotlinretrofit.repository.models.Question

data class QuestionsResponse(
    @SerializedName("questions")
    var questions: ArrayList<Question>
)
