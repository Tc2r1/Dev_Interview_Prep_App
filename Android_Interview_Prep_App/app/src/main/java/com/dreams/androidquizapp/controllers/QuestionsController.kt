package com.dreams.androidquizapp.controllers

import android.util.Log
import com.dreams.androidquizapp.models.Question
import com.dreams.androidquizapp.network.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class QuestionsController {
    private var questionsList: ArrayList<Question>? = null
    val questions: ArrayList<Question>
        get() {
            questionsList = ArrayList()
            loadQuestions()
//            getQuestions()
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

    private fun getQuestions() {
        // Call AnswersApiService to enqueue Retrofit request (starts the call on background thread). Returns call object
        QuestionsApi.retrofitService.getQuestionsJson().enqueue(object : Callback<QuestionsResponse> {
            override fun onFailure(call: Call<QuestionsResponse>, t: Throwable) {
                //response = "Failure:" + t.message
                Log.i("I/getAnswersObject", "$call")
                Log.i("I/onFailure", "${t.message}")
            }

            override fun onResponse(call: Call<QuestionsResponse>, response: Response<QuestionsResponse>) {
                //response = "Success: ${response.body()?.size} answers received"
                Log.i("I/onResponse", "Success: ${response.code()}")
                val array = response.body()
                Log.i("I/onResponse", "Test $array")
                val arraySize = array?.questions?.size

                for (i in 0 until arraySize!!) {
                    val tempId = array.questions[i].id
                    val tempQuestion = array.questions[i].question
                    val tempDetails = array.questions[i].details
                    val tempType = array.questions[i].questionType
                    val tempShortAns = array.questions[i].shortAns
                    val tempTF = array.questions[i].trueOrFalse
                    val temp: Question
                    Log.i("I/Assign", "Question: $tempQuestion $tempId")

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
                    questionsList?.add(temp)
                }
            }
        })
    }
}
//for (int i = 0; i < array.length(); i++) {
//              JSONObject object = array.getJSONObject(i);
//              String tempQuestion = object.getString("question");
//              String tempKey = object.getString("key");
//              Question temp;
//
//              if (object.getString("summary") != null) {
//                String tempSummary = object.getString("summary");
//                temp = new Question(tempQuestion, tempKey, tempSummary);
//              } else {
//                temp = new Question(tempQuestion, tempKey);
//              }
//              quizList.add(temp);
//            }

//      questionService.listAll();
//      // Same as getAnswers
//
//      AsyncTask<String, Void, Void> task = new AsyncTask<String, Void, Void>() {
//
//        @Override
//        protected Void doInBackground(String... strings) {
//          OkHttpClient client = new OkHttpClient();
//          Request request = new Request.Builder()
//                                    .url("https://tchost.000webhostapp.com/getquiz_android.php?")
//                                    .build();
//
//          try {
//            Response response = client.newCall(request).execute();
//            JSONArray array = new JSONArray(response.body().string());
//
//            for (int i = 0; i < array.length(); i++) {
//              JSONObject object = array.getJSONObject(i);
//              String tempQuestion = object.getString("question");
//              String tempKey = object.getString("key");
//              Question temp;
//
//              if (object.getString("summary") != null) {
//                String tempSummary = object.getString("summary");
//                temp = new Question(tempQuestion, tempKey, tempSummary);
//              } else {
//                temp = new Question(tempQuestion, tempKey);
//              }
//              quizList.add(temp);
//            }
//
//          } catch (JSONException | IOException e) {
//            e.printStackTrace();
//          }
//          return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//          super.onPostExecute(aVoid);
//
//          // once questions and answers have been retrieved, create a quiz.
//          createQuiz();
//        }
//      };
//      task.execute();