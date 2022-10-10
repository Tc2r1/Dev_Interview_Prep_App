package com.interviewprep.kotlinretrofit.network

import com.interviewprep.kotlinretrofit.models.Answer
import com.google.gson.annotations.SerializedName

data class AnswersResponse (
    @SerializedName("answers")
    var answers: ArrayList<Answer>
)
//{
//    @SerializedName("answers")
//    var answers = ArrayList<Answer>()
//}
