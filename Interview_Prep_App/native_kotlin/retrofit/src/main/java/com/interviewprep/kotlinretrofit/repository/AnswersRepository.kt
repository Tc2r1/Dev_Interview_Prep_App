package com.interviewprep.kotlinretrofit.repository

import android.util.Log
import com.interviewprep.kotlinretrofit.models.Answer
import com.interviewprep.kotlinretrofit.network.AnswersApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AnswersRepository {

    private val TAG = "ACTEST"

    suspend fun getTheAnswers(): ArrayList<Answer> {
        val answersList: ArrayList<Answer> = arrayListOf()
        withContext(Dispatchers.IO) {
            val response = AnswersApi.retrofitService.requestAnswers()
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
}
