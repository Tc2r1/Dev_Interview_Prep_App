package com.interviewprep.kotlinretrofit.repository.tc2rgithubrepository.source

import com.interviewprep.kotlinretrofit.repository.models.Answer
import com.interviewprep.kotlinretrofit.repository.models.Question

interface Tc2rDataSource {

    suspend fun getAndroidAnswers(): ArrayList<Answer>

    suspend fun getAndroidQuestions(): ArrayList<Question>

}
