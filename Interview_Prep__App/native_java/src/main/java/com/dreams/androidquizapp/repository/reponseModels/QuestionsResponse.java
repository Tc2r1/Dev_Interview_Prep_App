package com.dreams.androidquizapp.repository.reponseModels;

import com.dreams.androidquizapp.repository.models.Question;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Tc2r on 5/19/2017.
 * <p>
 * Description:
 */

public class QuestionsResponse {
    @SerializedName("questions")
    private ArrayList<Question> questionsList;

    public ArrayList<Question> getQuestionsList() {
        return questionsList;
    }
}
