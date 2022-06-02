package com.dreams.androidquizapp.controllers

import android.util.Log
import com.dreams.androidquizapp.models.Question
import com.dreams.androidquizapp.network.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class QuestionsController {

    val job = Job()
    val coroutineScope = CoroutineScope(Dispatchers.IO + job)
    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }
    private val TAG = "QCTEST"
    private var questionsList: ArrayList<Question>? = null
    val questions: ArrayList<Question>
        get() {
            questionsList = ArrayList()
            loadQuestions()
            coroutineScope.launch {
                getQuestions()
            }
            return questionsList as ArrayList<Question>
        }

    private fun loadQuestions() {
        val question1 = Question.Builder(
            1,
            "multi",
            "What is Android?",
            "Android is a stack of software for mobile devices which includes an Operating System, middleware and some key applications. The application executes within its own process and its own instance of Dalvik Virtual Machine."
        )
            .shortAns("A stack of software for mobile devices.")
            .build()
        questionsList!!.add(question1)
        val question2 = Question.Builder(
            2,
            "multi",
            "What is a Service?",
            "Android is a stack of software for mobile devices which includes an Operating System, middleware and some key applications. The application executes within its own process and its own instance of Dalvik Virtual Machine.A component that runs in the background to perform long term running operations, Services continue while app is destroyed."
        )
            .shortAns("It performs background functionalities.")
            .build()
        questionsList!!.add(question2)
        val question3 = Question.Builder(
            3,
            "multi",
            "What is the APK format?",
            "The Android packaging key is compressed with classes,UI's, supportive assets and manifest.All files are compressed to a single file is called APK."
        )
            .shortAns("It is compressed with classes,UI's, supportive assets and manifest.")
            .build()
        questionsList!!.add(question3)
        val question4 = Question.Builder(
            4,
            "multi",
            "What is an intent?",
            "It is connected to either the external world of application or internal world of application ,Such as, opening a pdf is an intent and connect to the web browser.etc."
        )
            .shortAns("It is a declaration to do something.")
            .build()
        questionsList!!.add(question4)
        val question5 = Question.Builder(
            5,
            "multi",
            "What is an android manifest file?",
            "Every application must have an AndroidManifest.xml file (with precisely that name) in its root directory. The manifest file presents essential information about your app to the Android system, information the system must have before it can run any of the app's code."
        )
            .shortAns(" It is a resource file which contains all the details needed by the android system about the application.")
            .build()
        questionsList!!.add(question5)
    }

    suspend fun getQuestions(): ArrayList<Question> {
        var questionsList: ArrayList<Question> = arrayListOf()
        withContext(Dispatchers.IO){
            // Call AnswersApiService to enqueue Retrofit request (starts the call on background thread). Returns call object
            val response = QuestionsApi.retrofitService.getQuestionsJson()
            val array = response.body()
            Log.i(TAG, "onResponse Array: $array")
            var count = 0
            for (item in array?.questions!!) {
                val tempId = item.id
                val tempQuestion = item.question
                val tempDetails = item.details
                val tempType = item.questionType
                val tempShortAns = item.shortAns
                val tempTF = item.trueOrFalse
                val temp: Question
                Log.i(TAG, "TempQuestion: $tempQuestion $tempId")

                if (tempShortAns != null) {
                    temp = Question(
                        Question.Builder(
                            tempId,
                            tempType,
                            tempQuestion,
                            tempDetails
                        ).shortAns(tempShortAns).trueOrFalse(tempTF)
                    )
                } else {
                    temp = Question(
                        Question.Builder(
                            tempId,
                            tempType,
                            tempQuestion,
                            tempDetails
                        )
                    )
                }
                questionsList.add(temp)
//                count++
//                if (count == 3){
//                    break
//                }
            }
        }
        return questionsList
    }
}