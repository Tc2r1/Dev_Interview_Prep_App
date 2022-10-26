package com.interviewprep.kotlinviewbinding.repository.models.response

import com.google.gson.annotations.SerializedName
import com.interviewprep.kotlinviewbinding.repository.models.Question

data class QuestionsResponse(
    @SerializedName("questions")
    var questions: ArrayList<Question>
)
