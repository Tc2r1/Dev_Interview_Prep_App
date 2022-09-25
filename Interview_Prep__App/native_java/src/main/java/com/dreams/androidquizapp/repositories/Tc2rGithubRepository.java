package com.dreams.androidquizapp.repositories;

import com.dreams.androidquizapp.network.RetrofitBuilders;
import com.dreams.androidquizapp.repositories.models.response.AnswersResponse;
import com.dreams.androidquizapp.repositories.models.response.QuestionsResponse;
import com.dreams.androidquizapp.repositories.tc2rgithubrepository.source.remote.Tc2rGithubService;

import retrofit2.Call;

public class Tc2rGithubRepository {
    private static final RetrofitBuilders retrofitBuilder = new RetrofitBuilders();

    private final Tc2rGithubService tc2rGithubService = retrofitBuilder.tc2rGithubService;

    public Call<AnswersResponse> getAnswersList = tc2rGithubService.getAnswersList();

    public Call<QuestionsResponse> getQuestionsList = tc2rGithubService.getQuestionsList();
}
