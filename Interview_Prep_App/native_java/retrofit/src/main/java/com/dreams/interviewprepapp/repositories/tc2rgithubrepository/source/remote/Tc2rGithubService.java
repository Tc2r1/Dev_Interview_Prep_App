package com.dreams.interviewprepapp.repositories.tc2rgithubrepository.source.remote;


import com.dreams.interviewprepapp.repositories.models.response.AnswersResponse;
import com.dreams.interviewprepapp.repositories.models.response.QuestionsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Tc2rGithubService {
    // get method and URL specified in the annotation

    // Gets Android answers objects
    @GET("master/Languages/Android/answers.json")
    Call<AnswersResponse> getAndroidAnswersList();

    // Gets Android questions objects
    @GET("master/Languages/Android/questions.json")
    Call<QuestionsResponse> getAndroidQuestionsList();
    
    // Gets C# answers objects
    @GET("master/Languages/C%23/answers.json")
    Call<AnswersResponse> getCSharpAnswers();

    // Gets C# questions objects
    @GET("master/Languages/C%23/questions.json")
    Call<QuestionsResponse> getCSharpQuestionsJson();

    // Gets C answers objects
    @GET("master/Languages/C/answers.json")
    Call<AnswersResponse> getCAnswers();

    // Gets C questions objects
    @GET("master/Languages/C/questions.json")
    Call<QuestionsResponse> getCQuestionsJson();

    // Gets CPP answers objects
    @GET("master/Languages/CPP/answers.json")
    Call<AnswersResponse> getCPPAnswers();

    // Gets CPP questions objects
    @GET("master/Languages/CPP/questions.json")
    Call<QuestionsResponse> getCPPQuestionsJson();

    // Gets DART answers objects
    @GET("master/Languages/DART/answers.json")
    Call<AnswersResponse> getDartAnswers();

    // Gets DART questions objects
    @GET("master/Languages/DART/questions.json")
    Call<QuestionsResponse> getDartQuestionsJson();

    // Gets DP answers objects
    @GET("master/Languages/DP/answers.json")
    Call<AnswersResponse> getDPAnswers();

    // Gets DP questions objects
    @GET("master/Languages/DP/questions.json")
    Call<QuestionsResponse> getDPQuestionsJson();

    // Gets DSA answers objects
    @GET("master/Languages/DSA/answers.json")
    Call<AnswersResponse> getDSAAnswers();

    // Gets DSA questions objects
    @GET("master/Languages/DSA/questions.json")
    Call<QuestionsResponse> getDSAQuestionsJson();

    // Gets Golang answers objects
    @GET("master/Languages/Golang/answers.json")
    Call<AnswersResponse> getGolangAnswers();

    // Gets Golang questions objects
    @GET("master/Languages/Golang/questions.json")
    Call<QuestionsResponse> getGolangQuestionsJson();

    // Gets HTML5 answers objects
    @GET("master/Languages/HTML5/answers.json")
    Call<AnswersResponse> getHTML5Answers();

    // Gets HTML5 questions objects
    @GET("master/Languages/HTML5/questions.json")
    Call<QuestionsResponse> getHTML5QuestionsJson();

    // Gets JS answers objects
    @GET("master/Languages/JS/answers.json")
    Call<AnswersResponse> getJSAnswers();

    // Gets JS questions objects
    @GET("master/Languages/JS/questions.json")
    Call<QuestionsResponse> getJSQuestionsJson();

    // Gets Java answers objects
    @GET("master/Languages/Java/answers.json")
    Call<AnswersResponse> getJavaAnswers();

    // Gets Java questions objects
    @GET("master/Languages/Java/questions.json")
    Call<QuestionsResponse> getJavaQuestionsJson();

    // Gets PHP answers objects
    @GET("master/Languages/PHP/answers.json")
    Call<AnswersResponse> getPHPAnswers();

    // Gets PHP questions objects
    @GET("master/Languages/PHP/questions.json")
    Call<QuestionsResponse> getPHPQuestionsJson();

    // Gets Python answers objects
    @GET("master/Languages/Python/answers.json")
    Call<AnswersResponse> getPythonAnswers();

    // Gets Python questions objects
    @GET("master/Languages/Python/questions.json")
    Call<QuestionsResponse> getPythonQuestionsJson();

    // Gets Ruby answers objects
    @GET("master/Languages/Ruby/answers.json")
    Call<AnswersResponse> getRubyAnswers();

    // Gets Ruby questions objects
    @GET("master/Languages/Ruby/questions.json")
    Call<QuestionsResponse> getRubyQuestionsJson();

    // Gets iOS answers objects
    @GET("master/Languages/iOS/answers.json")
    Call<AnswersResponse> getIOSAnswers();

    // Gets iOS questions objects
    @GET("master/Languages/iOS/questions.json")
    Call<QuestionsResponse> getIOSQuestionsJson();

}
