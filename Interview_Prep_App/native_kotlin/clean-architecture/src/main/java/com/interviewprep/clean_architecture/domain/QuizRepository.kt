package com.interviewprep.clean_architecture.domain

interface QuizRepository {
    suspend fun fetchQuiz(questionCount: Int, answersPerQuestion: Int): Result<Quiz>
}