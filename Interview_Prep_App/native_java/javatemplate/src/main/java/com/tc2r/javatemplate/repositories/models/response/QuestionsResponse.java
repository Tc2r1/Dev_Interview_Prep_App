package com.tc2r.javatemplate.repositories.models.response;

import com.tc2r.javatemplate.repositories.models.Question;

import java.util.ArrayList;

// FIXME: Create Response objects to handle data returned from api.
public class QuestionsResponse {
    private ArrayList<Question> questionsList;

    public ArrayList<Question> getQuestionsList() {
        return questionsList;
    }
}
