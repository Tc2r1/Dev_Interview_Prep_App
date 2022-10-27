package com.interviewprep.clean_architecture.data

import com.interviewprep.clean_architecture.domain.Answer
import com.interviewprep.clean_architecture.domain.Question
import com.interviewprep.clean_architecture.domain.Quiz
import com.interviewprep.clean_architecture.domain.QuizRepository
import javax.inject.Inject

class QuizRepositoryFake @Inject constructor() : QuizRepository {
    private fun fakeQuestions(count: Int) = List(count) {
        Question(
            title = "question #$it",
            details = "",
            answers = listOf(Answer("body", "")),
            correctAnswerId = 0
        )
    }

    override suspend fun fetchQuiz(questionCount: Int, answersPerQuestion: Int): Result<Quiz> {
        val quiz = Quiz(
            currentQuestionNumber = 0,
            correctAnswerCount = 0,
            questions = fakeQuestions(questionCount)
        )
        return Result.success(quiz)
    }
}