package com.interviewprep.kotlinretrofit.repository.models

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
        fun possibleAnswers(listOfAnswers: List<Answer>): Builder {
            answerList = listOfAnswers
            return this
        }

        fun quizQuestion(question: String): Builder {
            this.question = question
            return this
        }

        fun build(): MultipleChoiceQuestion {
            return MultipleChoiceQuestion(this)
        }
    }

    init {
        question = builder.question
        answers = builder.answerList
    }
}
