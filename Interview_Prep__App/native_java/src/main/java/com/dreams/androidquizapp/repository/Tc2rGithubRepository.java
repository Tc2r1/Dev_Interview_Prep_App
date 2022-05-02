package com.dreams.androidquizapp.repository;

import com.dreams.androidquizapp.network.RetrofitServiceProvider;
import com.dreams.androidquizapp.network.Tc2rGithubService;
import com.dreams.androidquizapp.repository.reponseModels.AnswersResponse;
import com.dreams.androidquizapp.repository.reponseModels.QuestionsResponse;

import retrofit2.Call;

public class Tc2rGithubRepository {
    private static final RetrofitServiceProvider retrofitServiceProvider = new RetrofitServiceProvider();

    private final Tc2rGithubService tc2rGithubService = retrofitServiceProvider.tc2rGithubService;

    public Call<AnswersResponse> getAnswersList = tc2rGithubService.getAnswersList();

    public Call<QuestionsResponse> getQuestionsList = tc2rGithubService.getQuestionsList();
}
