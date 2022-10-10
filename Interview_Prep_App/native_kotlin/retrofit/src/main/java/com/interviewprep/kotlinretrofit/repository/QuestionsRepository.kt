package com.interviewprep.kotlinretrofit.repository

import android.util.Log
import com.interviewprep.kotlinretrofit.models.Question
import com.interviewprep.kotlinretrofit.network.QuestionsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuestionsRepository {

    private val TAG = "QCTEST"

    suspend fun getQuestions(): ArrayList<Question> {
        val questionsList: ArrayList<Question> = arrayListOf()
        withContext(Dispatchers.IO) {
            val response = QuestionsApi.retrofitService.getQuestionsJson()
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
