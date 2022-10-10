package com.interviewprep.kotlinretrofit.network

import com.google.gson.annotations.SerializedName
import com.interviewprep.kotlinretrofit.models.Answer

data class AnswersResponse(
    @SerializedName("answers")
    var answers: ArrayList<Answer>
)
