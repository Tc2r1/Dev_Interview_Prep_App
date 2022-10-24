package com.interviewprep.kotlinretrofit.repository.tc2rgithubrepository.source.local

import com.interviewprep.kotlinretrofit.database.QuestionsDao
import com.interviewprep.kotlinretrofit.repository.models.Answer
import com.interviewprep.kotlinretrofit.repository.models.Question
import com.interviewprep.kotlinretrofit.repository.tc2rgithubrepository.source.Tc2rDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Tc2rGithubLocalDataSource
 *
 * Concrete implementation of a data source as a db.
 */
class Tc2rGithubLocalDataSource internal constructor(
    private val questionsDao: QuestionsDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : Tc2rDataSource {

    override suspend fun getAndroidAnswers(): ArrayList<Answer> {
        TODO("Not yet implemented")
    }

    override suspend fun getAndroidQuestions(): ArrayList<Question> {

        return questionsDao.getAllQuestions()
    }
}
