package com.interviewprep.moshi_androidlion48.repository.models

// FIXME: Create Response objects to handle data returned from api.
// Consider using JSON to POJO plugin or website convertor.
data class Question(
    val id: Int = 0,
    val question: String = "",
    val details: String = "",
    val questionType: String = "",
    val trueOrFalse: Boolean = true,
    val shortAns: String = "",
    val tag: String = ""
)
