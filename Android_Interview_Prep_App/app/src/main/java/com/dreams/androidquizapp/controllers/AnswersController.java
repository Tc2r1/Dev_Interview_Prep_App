package com.dreams.androidquizapp.controllers;

import com.dreams.androidquizapp.models.Answer;

import java.util.ArrayList;

public class AnswersController
{


  private ArrayList<Answer> answersList;


  public ArrayList<Answer> getAnswers()
  {

    answersList = new ArrayList<>();
    loadAnswers();

    return answersList;
  }


  private void loadAnswers()
  {

    Answer answer1 = new Answer();

    answer1.setAnswer(
            "It will perform the inter connection between activities and the data " + "passing mechanism.");
    answer1.setDetails(
            "An Intent is connected to either the external world of application or " + "internal world of application ,Such as, opening a pdf is an intent and connect to the web browser.etc.");
    answersList.add(answer1);


    Answer answer2 = new Answer();
    answer2.setAnswer("It is the file type used by Android devices.");
    answer2.setDetails(
            "The Android packaging key is compressed with classes, UI's, supportive " + "assets and manifest. All files are compressed to a single file.");
    answersList.add(answer2);


    Answer answer3 = new Answer();
    answer3.setAnswer("It specifies the component to be invoked from activity.");
    answer3.setDetails(
            "Android Explicit intent specifies the component to be invoked from " + "activity. We can call another activity in android by explicit " + "intent.");
    answersList.add(answer3);

    Answer answer4 = new Answer();
    answer4.setAnswer(
            "It provides information of available components provided by the system to " + "be invoked.");
    answer4.setDetails(
            "Implicit Intent doesn't specifiy the component. In such case, intent provides information of available components provided by the system that is to be invoked.");
    answersList.add(answer4);

    Answer answer5 = new Answer();
    answer5.setAnswer("It presents essential information about your app to the Android system");
    answer5.setDetails(
            "Every application must have an AndroidManifest.xml file (with precisely that name) in its root directory. The manifest file presents essential information about your app to the Android system, information the system must have before it can run any of the app's code.");
    answersList.add(answer5);

    Answer answer6 = new Answer();
    answer6.setAnswer(
            "It provides information of available components provided by the system to " + "be invoked.");
    answer6.setDetails(
            "Implicit Intent doesn't specifiy the component. In such case, intent " + "provides information of available components provided by the system that is to be invoked.");
    answersList.add(answer6);

    Answer answer7 = new Answer();
    answer7.setAnswer(
            "It provides information of available components provided by the system to " + "be invoked.");
    answer7.setDetails(
            "Implicit Intent doesn't specifiy the component. In such case, intent " + "provides information of available components provided by the system that is to be invoked.");
    answersList.add(answer7);
  }

//  // Creates an AsyncTask to make a call to my server php file to return
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
//		task.execute();

}
