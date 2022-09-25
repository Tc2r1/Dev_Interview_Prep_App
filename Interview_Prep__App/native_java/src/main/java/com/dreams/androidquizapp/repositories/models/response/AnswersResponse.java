package com.dreams.androidquizapp.repositories.models.response;

import com.dreams.androidquizapp.repositories.models.Answer;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Tc2r on 5/19/2017.
 * <p>
 * Description:
 */

public class AnswersResponse {
    @SerializedName("answers")
    private ArrayList<Answer> answersList;

    public ArrayList<Answer> getAnswersList() {
        return answersList;
    }

}
