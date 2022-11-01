package com.interviewprep.kotlinviewbinding.repository.models.response

import com.google.gson.annotations.SerializedName
import com.interviewprep.kotlinviewbinding.repository.models.Answer

data class AnswersResponse(
    @SerializedName("answers")
    var answers: ArrayList<Answer>
)
