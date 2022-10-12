package com.tc2r.javatemplate.repositories.tc2rgithubrepository.source.remote;


import com.tc2r.javatemplate.repositories.models.Answer;

import java.util.ArrayList;
import java.util.Arrays;

public interface Tc2rGithubService {
    // Request method and URL specified in the annotation

    // FIXME: Use your own preference to make request to the api
    default ArrayList<Answer> getAnswers() {
        Answer tempAnswer = new Answer("It will perform the inter connection between activities and the data " + "passing mechanism.",
                                       "An Intent is connected to either the external world of application or " + "internal world of application ,Such as, opening a pdf is an intent and connect to the web browser" + ".etc.");

        return new ArrayList<>(Arrays.asList(tempAnswer, tempAnswer, tempAnswer, tempAnswer, tempAnswer, tempAnswer));
    }

    // FIXME: Use your own preference to make request to the api
    void getQuestionsList();
}
