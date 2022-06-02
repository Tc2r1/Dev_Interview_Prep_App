package com.dreams.androidquizapp.repository

import android.util.Log
import com.dreams.androidquizapp.models.Answer
import com.dreams.androidquizapp.network.AnswersApi
import kotlinx.coroutines.*
import java.util.ArrayList

class AnswersRepository {

    private val TAG = "ACTEST"

    private var answersList: ArrayList<Answer>? = null
    val answers: ArrayList<Answer?>
        get() {
            answersList = ArrayList()
//            loadAnswers()
            return answersList as ArrayList<Answer?>
        }

    suspend fun getTheAnswers(): ArrayList<Answer> {
        var answersList: ArrayList<Answer> = arrayListOf()
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

    private fun loadAnswers() {
        val answer1 = Answer()
        answer1.answer =
            "It will perform the inter connection between activities and the data " + "passing mechanism."
        answer1.details =
            "An Intent is connected to either the external world of application or " + "internal world of application ,Such as, opening a pdf is an intent and connect to the web browser.etc."
        answersList!!.add(answer1)
        val answer2 = Answer()
        answer2.answer = "It is the file type used by Android devices."
        answer2.details =
            "The Android packaging key is compressed with classes, UI's, supportive " + "assets and manifest. All files are compressed to a single file."
        answersList!!.add(answer2)
        val answer3 = Answer()
        answer3.answer = "It specifies the component to be invoked from activity."
        answer3.details =
            "Android Explicit intent specifies the component to be invoked from " + "activity. We can call another activity in android by explicit " + "intent."
        answersList!!.add(answer3)
        val answer4 = Answer()
        answer4.answer =
            "It provides information of available components provided by the system to " + "be invoked."
        answer4.details =
            "Implicit Intent doesn't specifiy the component. In such case, intent provides information of available components provided by the system that is to be invoked."
        answersList!!.add(answer4)
        val answer5 = Answer()
        answer5.answer = "It presents essential information about your app to the Android system"
        answer5.details =
            "Every application must have an AndroidManifest.xml file (with precisely that name) in its root directory. The manifest file presents essential information about your app to the Android system, information the system must have before it can run any of the app's code."
        answersList!!.add(answer5)
        val answer6 = Answer()
        answer6.answer =
            "It provides information of available components provided by the system to " + "be invoked."
        answer6.details =
            "Implicit Intent doesn't specifiy the component. In such case, intent " + "provides information of available components provided by the system that is to be invoked."
        answersList!!.add(answer6)
        val answer7 = Answer()
        answer7.answer =
            "It provides information of available components provided by the system to " + "be invoked."
        answer7.details =
            "Implicit Intent doesn't specifiy the component. In such case, intent " + "provides information of available components provided by the system that is to be invoked."
        answersList!!.add(answer7)
    }


}
