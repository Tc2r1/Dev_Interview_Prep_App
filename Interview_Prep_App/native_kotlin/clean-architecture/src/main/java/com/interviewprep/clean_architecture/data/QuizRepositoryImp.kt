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

    override suspend fun fetchQuiz(questionCount: Int, answersPerQuestion: Int): Result<Quiz> =
        withContext(Dispatchers.IO) {
            val questions =
                getAllQuestions()
                    .filter { it.shortAns.isNotBlank() }
                    .takeRandomN(questionCount)
                    .map { domainQuestionFromModel(it, answersPerQuestion) }
            Result.success(
                Quiz(
                    0,
                    0,
                    questions
                )
            )
        }

    private fun domainQuestionFromModel(model: QuestionModel, answersCount: Int) =
        when (model.trueOrFalse) {
            true -> trueOrFalseQuestion(model)
            false -> multiChoiceQuestion(model, answersCount)
        }


    private fun trueOrFalseQuestion(model: QuestionModel): Question {
        val answers = listOf(
            Answer("True", model.details),
            Answer("False", model.details)
        )

        return Question(
            model.question,
            model.details,
            answers,
            if (model.shortAns == "True") 0 else 1
        )
    }

    private fun multiChoiceQuestion(model: QuestionModel, answersCount: Int): Question {
        val correctAnswer = Answer(model.shortAns, model.details)
        val answers =
            getAllAnswers()
                .filter { ans -> ans.answer !in model.shortAns && ans.answer.isNotBlank() }
                .takeRandomN(answersCount - 1)
                .map(AnswerModel::toDomain)
                .plus(correctAnswer)
                .shuffled()

        return Question(
            model.question,
            model.details,
            answers,
            answers.indexOf(correctAnswer)
        )
    }


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

    private fun <T> List<T>.takeRandomN(n: Int) =
        asSequence()
            .shuffled()
            .take(n)
            .toList()

}