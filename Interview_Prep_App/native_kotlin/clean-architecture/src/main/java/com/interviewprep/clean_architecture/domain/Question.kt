package com.interviewprep.clean_architecture.domain

data class Question(
    val title: String,
    val details: String,
    val answers: List<Answer>,
    val correctAnswerId: Int
)
