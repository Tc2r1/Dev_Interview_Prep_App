package com.interviewprep.template.repository.tc2rgithubrepository

import com.interviewprep.template.network.RetrofitBuilders
import com.interviewprep.template.repository.models.Answer
import com.interviewprep.template.repository.models.Question

class Tc2rGithubRepository {
    private val TAG = "ACTEST"

    companion object {
        private val retrofitBuilder: RetrofitBuilders = RetrofitBuilders()
    }

    // Creates API object using Retrofit to implement API Service
    private val tc2rGithubService = retrofitBuilder.tc2rGithubService

    // FIXME use this function to make calls to api and convert the response
    // FIXME It is best to do this off of the main thread.
    fun getTheAnswers(): ArrayList<Answer> {
        // val response = tc2rGithubService.requestAnswers()
        // val array = response.body()

        return arrayListOf(Answer(), Answer(), Answer(), Answer(), Answer()) // return list of Answers
    }

    // FIXME use this function to make calls to api and convert the response
    // FIXME It is best to do this off of the main thread.
    fun getQuestions(): ArrayList<Question> {
        // val response = tc2rGithubService.getQuestionsJson()
        // val array = response.body()

        return arrayListOf(Question(), Question(), Question(), Question(), Question()) // return list of questions.
    }
}
