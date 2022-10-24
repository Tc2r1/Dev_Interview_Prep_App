package com.interviewprep.clean_architecture.data

import android.content.Context
import com.interviewprep.clean_architecture.data.models.AnswerModel
import com.interviewprep.clean_architecture.data.models.AnswersListModel
import com.interviewprep.clean_architecture.data.models.QuestionModel
import com.interviewprep.clean_architecture.data.models.QuestionsListModel
import com.interviewprep.clean_architecture.domain.Answer
import com.interviewprep.clean_architecture.domain.Question
import com.interviewprep.clean_architecture.domain.Quiz
import com.interviewprep.clean_architecture.domain.QuizRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.IOException
import javax.inject.Inject

private const val ANSWERS_URL = "answers.json"
private const val QUESTIONS_URL = "questions.json"

class QuizRepositoryImp @Inject constructor(
    @ApplicationContext private val context: Context,
) : QuizRepository {
    private val jsonParser = Json { ignoreUnknownKeys = true }

    private fun getJsonDataFromAsset(fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    private fun getAllAnswers(): List<AnswerModel> {
        val jsonString = getJsonDataFromAsset(ANSWERS_URL)

        return jsonString?.let { data ->
            jsonParser.decodeFromString<AnswersListModel>(data).answers
        } ?: listOf()
    }

    private fun getAllQuestions(): List<QuestionModel> {
        val jsonString = getJsonDataFromAsset(QUESTIONS_URL)

        return jsonString?.let { data ->
            jsonParser.decodeFromString<QuestionsListModel>(data).questions
        } ?: listOf()
    }

    override suspend fun fetchQuiz(questionCount: Int, answersPerQuestion: Int): Result<Quiz> =
        withContext(Dispatchers.IO) {
            val fakeAnswerCount = answersPerQuestion - 1

            val answers = getAllAnswers().takeRandomN(questionCount * fakeAnswerCount)
            val questions = getAllQuestions().takeRandomN(questionCount)

            val answersRandom =
                answers
                    .filter { ans -> ans.answer !in questions.map { it.shortAns } }
                    .takeRandomN(questionCount * fakeAnswerCount)

            val multiChoiceQuestions = questions.mapIndexed { index, questionModel ->
                val correctAnswer = Answer(questionModel.shortAns, questionModel.details)
                val allAnswers =
                    answersRandom
                        .subList(index * fakeAnswerCount, (index + 1) * fakeAnswerCount)
                        .map(AnswerModel::toDomain)
                        .plus(correctAnswer)
                        .shuffled()

                Question(
                    questionModel.question,
                    questionModel.details,
                    allAnswers,
                    allAnswers.indexOf(correctAnswer)
                )
            }
            Result.success(
                Quiz(
                    0,
                    0,
                    multiChoiceQuestions
                )
            )
        }

    private fun <T> List<T>.takeRandomN(n: Int) =
        asSequence()
            .shuffled()
            .take(n)
            .toList()

}