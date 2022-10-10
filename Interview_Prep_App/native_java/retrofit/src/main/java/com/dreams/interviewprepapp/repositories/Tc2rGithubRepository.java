package com.dreams.interviewprepapp.repositories;

import com.dreams.interviewprepapp.network.RetrofitBuilders;
import com.dreams.interviewprepapp.repositories.models.response.AnswersResponse;
import com.dreams.interviewprepapp.repositories.models.response.QuestionsResponse;
import com.dreams.interviewprepapp.repositories.tc2rgithubrepository.source.remote.Tc2rGithubService;

import retrofit2.Call;

public class Tc2rGithubRepository {
    private static final RetrofitBuilders retrofitBuilder = new RetrofitBuilders();

    private final Tc2rGithubService tc2rGithubService = retrofitBuilder.tc2rGithubService;

    public Call<AnswersResponse> getAnswersList = tc2rGithubService.getAnswersList();

    public Call<QuestionsResponse> getQuestionsList = tc2rGithubService.getQuestionsList();
}
