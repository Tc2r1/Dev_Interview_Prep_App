package com.tc2r.javatemplate.repositories.models;

import java.util.List;

/**
 * Created by Tc2r on 5/19/2017.
 * <p>
 * Description:
 */

public class MultipleChoiceQuestion {
    private final String question;
    private final List<Answer> answerList;

    public String getQuestion() {
        return question;
    }

    public List<Answer> getAnswers() {
        return answerList;
    }


    public static class Builder {
        // Required Parameters
        private String question;
        private List<Answer> answerList;


        public Builder() {}

        public Builder possibleAnswers(List<Answer> listOfAnswers) {
            this.answerList = listOfAnswers;
            return this;
        }

        public Builder quizQuestion(String question) {
            this.question = question;
            return this;
        }

        public MultipleChoiceQuestion build() {
            return new MultipleChoiceQuestion(this);
        }
    }

    private MultipleChoiceQuestion(Builder builder) {
        question = builder.question;
        answerList = builder.answerList;
    }
}
