package com.interviewprep.clean_architecture.data.models

import com.interviewprep.clean_architecture.domain.Answer
import kotlinx.serialization.Serializable

@Serializable
data class AnswerModel(
    val answer: String,
    val details: String
) {
    fun toDomain() =
        Answer(answer, details)
}

@Serializable
data class AnswersListModel(
    val answers: List<AnswerModel>
)