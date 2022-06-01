package com.dreams.androidquizapp.controllers

import android.util.Log
import com.dreams.androidquizapp.models.Answer
import com.dreams.androidquizapp.network.AnswersApi
import com.dreams.androidquizapp.network.AnswersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class AnswersController {
    //@SerializedName("answers")
    private var answersList: ArrayList<Answer>? = null
    val answers: ArrayList<Answer?>
        get() {
            answersList = ArrayList()
            loadAnswers()
//            getAnswers()
            return answersList as ArrayList<Answer?>
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

    //private lateinit var response: String
    private fun getAnswers() {
        // Call AnswersApiService to enqueue Retrofit request (starts the call on background thread). Returns call object
        AnswersApi.retrofitService.getAnswers().enqueue(object : Callback<AnswersResponse> {
            override fun onFailure(call: Call<AnswersResponse>, t: Throwable) {
                //response = "Failure:" + t.message
                Log.i("I/getAnswersObject", "$call")
                Log.i("I/onFailure", "${t.message}")
            }

            override fun onResponse(call: Call<AnswersResponse>, response: Response<AnswersResponse>) {
                //response = "Success: ${response.body()?.size} answers received"
                Log.i("I/onResponse", "Success: ${response.code()}")
                val array = response.body()
                val test = array?.answers?.get(1)?.answer.toString()
                //val gsonObject = Gson().fromJson(response, Answer::class.java)
                Log.i("I/onResponse", "Test $test")
                val arraySize = array?.answers?.size
                for (i in 0 until arraySize!!) {
                    val tempAnswer = array.answers[i].answer
                    val tempAnswerString: String = tempAnswer.toString()
                    Log.i("I/Assign", "Answer: $tempAnswer $tempAnswerString")
                    val tempDetail = array.answers[i].details
                    val tempDetailsString: String = tempDetail.toString()
                    Log.i("I/Assign", "Detail: $tempDetail $tempDetailsString")
                    val temp = Answer(tempAnswerString, tempDetailsString)
                    answersList?.add(temp)
                }
                //getQuestions()
            }
        })
        //response = "Set API response here!"
    }

    // Creates an AsyncTask to make a call to my server php file to return
    //  // a json String array of incorrect answers.
    //
    //  AsyncTask<String, Void, Void> task = new AsyncTask<String, Void, Void>()
    //  {
    //
    //    @Override
    //    protected Void doInBackground(String... strings)
    //    {
    //      // Create client and request, this time using OkHttp.
    //      OkHttpClient client = new OkHttpClient();
    //      Request request = new Request.Builder()
    //                                .url("https://tchost.000webhostapp.com/getquiz_ans_android.php?")
    //                                .build();
    //
    //      try
    //      {
    //        // Check for a response, if recieved parse through it and assign rows to Answer Objects.
    //        Response response = client.newCall(request).execute();
    //        JSONArray array = new JSONArray(response.body().string());
    //
    //        for (int i = 0; i < array.length(); i++)
    //        {
    //          JSONObject object = array.getJSONObject(i);
    //          String tempAnswer = object.getString("topic");
    //
    //          Answer temp;
    //
    //          if (object.getString("details") != null)
    //          {
    //            String tempDetails = object.getString("details");
    //            temp = new Answer(tempAnswer, tempDetails);
    //          } else
    //          {
    //            temp = new Answer(tempAnswer);
    //          }
    //          answersList.add(temp);
    //        }
    //
    //      } catch (JSONException | IOException e)
    //      {
    //        e.printStackTrace();
    //      }
    //      return null;
    //    }
    //
    //    @Override
    //    protected void onPostExecute(Void aVoid)
    //    {
    //
    //      super.onPostExecute(aVoid);
    //      // Once complete
    //      // Get Questions From Database Online
    //      getQuestions();
    //
    //
    //    }
    //  };
    //  // execute the AsyncTask created above
    // 		task.execute();
}
