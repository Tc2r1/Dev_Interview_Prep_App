package com.interviewprep.clean_architecture.ui.quiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.interviewprep.clean_architecture.data.di.Dispatcher
import com.interviewprep.clean_architecture.data.di.InterviewPrepDispatchers
import com.interviewprep.clean_architecture.domain.QuizRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val quizRepository: QuizRepository,
    @Dispatcher(InterviewPrepDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    companion object {
        private const val QUESTIONS_PER_QUIZ = 10
        private const val REPOSITORY_DELAY = 2_000L
    }

    val uiState = MutableStateFlow(QuizUiState.Initial)

    init {
        repeatQuizFetch()
    }

    private fun repeatQuizFetch() {
        viewModelScope.launch(ioDispatcher) {
            while (uiState.value.quizState == null) {
                fetchQuiz()
                delay(REPOSITORY_DELAY)
            }
        }
    }

    private suspend fun fetchQuiz() {
        val quizResult = quizRepository.fetchQuiz(QUESTIONS_PER_QUIZ, 4)
        val quizState = quizResult.getOrNull()
        val quizThrowable = quizResult.exceptionOrNull()

        // catches instance where questions size == 0
        uiState.update {
            val isFinished = quizState?.isFinished == true

            if (isFinished) it.copy(isQuizFinished = true)
            else it.copy(quizState = quizState, error = quizThrowable)
        }
    }

    fun submitAnswer(answerId: Int) {
        val quiz = uiState.value.quizState ?: return
        if(answerId == -1) return

        val answer = quiz.currentQuestion.answers[answerId]
        val isCorrect = quiz.currentQuestion.correctAnswerId == answerId

        val correctAnswers = quiz.correctAnswerCount + if (isCorrect) 1 else 0
        val newQuizState = quiz.copy(
            correctAnswerCount = correctAnswers
        )

        uiState.update {
            it.copy(
                quizState = newQuizState,
                displayPopupUiState = AnswerDetailsUiState(answer, isCorrect)
            )
        }
    }

    fun popupShown() {
        uiState.update { it.copy(displayPopupUiState = null) }
    }

    fun goToNext() {
        val quiz = uiState.value.quizState ?: return
        val nextQuestionNumber = quiz.currentQuestionNumber + 1
        val nextQuizState = quiz.copy(currentQuestionNumber = nextQuestionNumber)
        val isFinished = quiz.currentQuestionNumber + 1 >= quiz.questions.size

        uiState.update {
            it.copy(
                isQuizFinished = isFinished,
                quizState = if (!isFinished) nextQuizState else quiz
            )
        }
    }

    fun startNewQuiz() {
        uiState.update { QuizUiState.Initial }
        repeatQuizFetch()
    }

    fun errorMessageShown() {
        uiState.update { it.copy(error = null) }
    }
}
