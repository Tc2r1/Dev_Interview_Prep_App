package com.dreams.androidquizapp.network

import com.dreams.androidquizapp.models.Answer
import com.google.gson.annotations.SerializedName

data class AnswersResponse (
    @SerializedName("answers")
    var answers: ArrayList<Answer>
)
//{
//    @SerializedName("answers")
//    var answers = ArrayList<Answer>()
//}