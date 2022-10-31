package com.interviewprep.clean_architecture.domain

data class Quiz(
    val currentQuestionNumber: Int,
    val correctAnswerCount: Int,
    val questions: List<Question>
) {
    val points: Int
        get() = 100 * correctAnswerCount / questions.size

    val currentQuestion: Question
        get() = questions[currentQuestionNumber]

    val isFinished: Boolean
        get() = currentQuestionNumber == questions.size

    companion object {
        val Initial = Quiz(0, 0, listOf())
    }
}