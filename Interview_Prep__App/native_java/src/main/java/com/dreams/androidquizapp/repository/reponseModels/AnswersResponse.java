package com.dreams.androidquizapp.repository.reponseModels;

import com.dreams.androidquizapp.repository.models.Answer;
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
