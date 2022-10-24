package com.interviewprep.clean_architecture.data.models

import kotlinx.serialization.Serializable

@Serializable
data class QuestionModel(
    val question: String,
    val details: String,
    val shortAns: String
)

@Serializable
data class QuestionsListModel(
    val questions: List<QuestionModel>
)