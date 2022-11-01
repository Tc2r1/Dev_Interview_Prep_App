package com.interviewprep.clean_architecture.ui.quiz

import com.interviewprep.clean_architecture.domain.Quiz
import com.interviewprep.clean_architecture.ui.score.FinalScore

data class QuizUiState(
    val quizState: Quiz?,
    val error: Throwable?,
    val displayPopupUiState: AnswerDetailsUiState?,
    val isQuizFinished: Boolean
) {
    companion object {
        val Initial = QuizUiState(
            null,
            null,
            null,
            false
        )
    }

    val finalScore
        get() = quizState?.let { FinalScore(it.questions.size, it.correctAnswerCount) }
}