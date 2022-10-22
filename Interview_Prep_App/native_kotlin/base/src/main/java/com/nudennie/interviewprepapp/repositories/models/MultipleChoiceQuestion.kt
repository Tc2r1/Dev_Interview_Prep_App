package com.nudennie.interviewprepapp.repositories.models

import com.nudennie.interviewprepapp.repositories.models.response.Answer

/**
 * Created by Tc2r on 5/19/2017.
 *
 *
 * Description:
 */
class MultipleChoiceQuestion private constructor(builder: Builder) {
    val question: String
    val answers: List<Answer>

    class Builder {
        // Required Parameters
        internal var question: String = ""
        internal var answerList: List<Answer> = emptyList()

        // Function to assign all the answer choices for a question
        fun possibleAnswers(listOfAnswers: List<Answer>): Builder {
            answerList = listOfAnswers
            return this
        }

        // Function to assign question
        fun quizQuestion(question: String): Builder {
            this.question = question
            return this
        }

        fun build(): MultipleChoiceQuestion {
            return MultipleChoiceQuestion(this)
        }
    }

    // Initialising the question and the answers
    init {
        question = builder.question
        answers = builder.answerList
    }
}
