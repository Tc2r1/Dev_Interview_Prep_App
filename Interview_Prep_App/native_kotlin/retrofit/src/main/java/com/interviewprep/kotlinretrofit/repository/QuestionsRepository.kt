package com.interviewprep.kotlinretrofit.repository

import android.util.Log
import com.interviewprep.kotlinretrofit.models.Question
import com.interviewprep.kotlinretrofit.network.QuestionsApi
import kotlinx.coroutines.*
import java.util.ArrayList

class QuestionsRepository {

    private val TAG = "QCTEST"

    private var questionsList: ArrayList<Question>? = null
    val questions: ArrayList<Question>
        get() {
            questionsList = ArrayList()
//            loadQuestions()
            return questionsList as ArrayList<Question>
        }

    suspend fun getQuestions(): ArrayList<Question> {
        var questionsList: ArrayList<Question> = arrayListOf()
        withContext(Dispatchers.IO){

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

    private fun loadQuestions() {
        val question1 = Question(
            1,
            "multi",
            "What is Android?",
            "Android is a stack of software for mobile devices which includes an Operating System, middleware and some key applications. The application executes within its own process and its own instance of Dalvik Virtual Machine.",
            "A stack of software for mobile devices.")
        questionsList!!.add(question1)
        val question2 = Question(
            2,
            "multi",
            "What is a Service?",
            "Android is a stack of software for mobile devices which includes an Operating System, middleware and some key applications. The application executes within its own process and its own instance of Dalvik Virtual Machine.A component that runs in the background to perform long term running operations, Services continue while app is destroyed.",
            "It performs background functionalities.")
        questionsList!!.add(question2)
        val question3 = Question(
            3,
            "multi",
            "What is the APK format?",
            "The Android packaging key is compressed with classes,UI's, supportive assets and manifest.All files are compressed to a single file is called APK.",
            "It is compressed with classes,UI's, supportive assets and manifest.")
        questionsList!!.add(question3)
        val question4 = Question(
            4,
            "multi",
            "What is an intent?",
            "It is connected to either the external world of application or internal world of application ,Such as, opening a pdf is an intent and connect to the web browser.etc.",
            "It is a declaration to do something.")
        questionsList!!.add(question4)
        val question5 = Question(
            5,
            "multi",
            "What is an android manifest file?",
            "Every application must have an AndroidManifest.xml file (with precisely that name) in its root directory. The manifest file presents essential information about your app to the Android system, information the system must have before it can run any of the app's code.",
            " It is a resource file which contains all the details needed by the android system about the application.")
        questionsList!!.add(question5)
    }

}
