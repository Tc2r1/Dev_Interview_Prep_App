package com.interviewprep.kotlinretrofit.repository.tc2rgithubrepository.source.remote

import android.util.Log
import com.interviewprep.kotlinretrofit.network.RetrofitBuilders
import com.interviewprep.kotlinretrofit.repository.models.Answer
import com.interviewprep.kotlinretrofit.repository.models.Question
import com.interviewprep.kotlinretrofit.repository.tc2rgithubrepository.source.Tc2rDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Tc2rGithubRemoteDataSource
 * Pilot Flying J
 *
 * Created by Nudennie White aka Tc2r on 2022...
 * Copyright © 2022 Pilot Flying J. All rights reserved.
 *
 */
class Tc2rGithubRemoteDataSource : Tc2rDataSource {

    private val TAG = "ACTEST"

    companion object {
        private val retrofitBuilder: RetrofitBuilders = RetrofitBuilders()
    }

    // Creates API object using Retrofit to implement API Service
    private val tc2rGithubService: Tc2rGithubService by lazy {
        retrofitBuilder.tc2rGithubService
    }
    override suspend fun getAndroidAnswers(): ArrayList<Answer> {
        val answersList: ArrayList<Answer> = arrayListOf()
        withContext(Dispatchers.IO) {
            val response = tc2rGithubService.requestAnswers()
            val array = response.body()

            val responseCode = response.code()
            Log.i(TAG, "$responseCode")

            for (item in array?.answers!!) {
                val tempAnswer = item.answer
                val tempDetail = item.details

                val temp = Answer(tempAnswer, tempDetail)

                Log.i(TAG, "onResponse TempAnswer: $tempAnswer")
                Log.i(TAG, "onResponse TempDetail: $tempDetail")
                answersList.add(temp)
            }
        }
        return answersList
    }

    override suspend fun getAndroidQuestions(): ArrayList<Question> {
        val questionsList: ArrayList<Question> = arrayListOf()
        withContext(Dispatchers.IO) {
            val response = tc2rGithubService.getQuestionsJson()
            val array = response.body()
            Log.i(TAG, "onResponse Array: $array")

            for (item in array?.questions!!) {
                val tempId = item.id
                val tempQuestion = item.question
                val tempDetails = item.details
                val tempType = item.questionType
                val tempShortAns = item.shortAns
                val tempTF = item.trueOrFalse

                // Skips boolean type questions. Implement feature later
                if (tempType == "bool") continue

                val temp = Question(
                    item.id,
                    item.questionType,
                    item.question,
                    tempDetails,
                    tempShortAns,
                    tempTF
                )

                Log.i(TAG, "TempQuestion: $tempQuestion $tempId")
                questionsList.add(temp)
            }
        }
        return questionsList
    }
}
