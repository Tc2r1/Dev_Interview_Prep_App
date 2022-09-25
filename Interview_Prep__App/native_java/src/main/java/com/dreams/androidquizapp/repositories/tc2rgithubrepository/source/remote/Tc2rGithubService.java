package com.dreams.androidquizapp.repositories.tc2rgithubrepository.source.remote;


import com.dreams.androidquizapp.repositories.models.response.AnswersResponse;
import com.dreams.androidquizapp.repositories.models.response.QuestionsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Tc2rGithubService {
    // Request method and URL specified in the annotation

    @GET("master/Languages/Android/answers.json")
    Call<AnswersResponse> getAnswersList();

    @GET("master/Languages/Android/questions.json")
    Call<QuestionsResponse> getQuestionsList();
}
