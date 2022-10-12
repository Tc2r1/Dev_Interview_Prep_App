package com.tc2r.javatemplate.repositories.models.response;

import com.tc2r.javatemplate.repositories.models.Answer;

import java.util.ArrayList;


// FIXME: Create Response objects to handle data returned from api.
public class AnswersResponse {
    private ArrayList<Answer> answersList;

    public ArrayList<Answer> getAnswersList() {
        return answersList;
    }
}
