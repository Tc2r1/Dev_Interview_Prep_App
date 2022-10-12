package com.tc2r.javatemplate.repositories;

import com.tc2r.javatemplate.network.RetrofitBuilders;
import com.tc2r.javatemplate.repositories.models.Answer;
import com.tc2r.javatemplate.repositories.models.Question;

import java.util.ArrayList;
import java.util.Arrays;

public class Tc2rGithubRepository {
    private static final RetrofitBuilders retrofitBuilder = new RetrofitBuilders();

    //private final Tc2rGithubService tc2rGithubService = retrofitBuilder.tc2rGithubService;

    // FIXME use this function to make calls to api and convert the response
    // FIXME It is best to do this off of the main thread.
    public ArrayList<Answer> getAnswersList() {

        Answer tempAnswer = new Answer("It will perform the inter connection between activities and the data " + "passing mechanism.",
                                       "An Intent is connected to either the external world of application or " + "internal world of application ,Such as, opening a pdf is an intent and connect to the web browser" + ".etc.");

        return new ArrayList<>(Arrays.asList(tempAnswer, tempAnswer, tempAnswer, tempAnswer, tempAnswer, tempAnswer));
    }


    // FIXME use this function to make calls to api and convert the response
    // FIXME It is best to do this off of the main thread.
    public ArrayList<Question> getQuestions() {
        // val response = tc2rGithubService.getQuestionsJson()
        // val array = response.body()

        Question question = new Question.Builder(1, "multi", "What is a cat?", "felines are cats born from cats which eat cats but aren't quite cats.")
                .shortAns("it is a four legged animal that eats mice")
                .build();

        return new ArrayList<>(Arrays.asList(question, question, question, question, question, question)); // return list of questions.
    }
}
