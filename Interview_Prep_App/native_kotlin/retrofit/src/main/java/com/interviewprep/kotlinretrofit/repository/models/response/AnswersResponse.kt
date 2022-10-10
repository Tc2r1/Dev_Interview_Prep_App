package com.interviewprep.kotlinretrofit.repository.models.response

import com.google.gson.annotations.SerializedName
import com.interviewprep.kotlinretrofit.repository.models.Answer

data class AnswersResponse(
    @SerializedName("answers")
    var answers: ArrayList<Answer>
)
