package com.interviewprep.clean_architecture.ui.quiz

import com.interviewprep.clean_architecture.domain.Answer

data class AnswerDetailsUiState(
    val answer: Answer,
    val isCorrect: Boolean
)