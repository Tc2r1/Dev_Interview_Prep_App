package com.nudennie.interviewprepapp.models

/**
 * Created by Tc2r on 5/19/2017.
 *
 *
 * Description:
 */
class Question private constructor(builder: Builder) {
    val id: Int
    val question: String
    val details: String
    val questionType: String
    val shortAns: String
    val trueOrFalse: String

    class Builder( // Required Parameters
        val id: Int,
        val questionType: String,
        val question: String,
        val details: String
    ) {
        // Optional Parameters - Initialized to default variables.
        var shortAns = ""
        var trueOrFalse = "false"
        fun shortAns(`val`: String): Builder {
            shortAns = `val`
            return this
        }

        fun trueOrFalse(`val`: String): Builder {
            trueOrFalse = `val`
            return this
        }

        fun build(): Question {
            return Question(this)
        }
    }

    init {
        id = builder.id
        questionType = builder.questionType
        question = builder.question
        details = builder.details
        shortAns = builder.shortAns
        trueOrFalse = builder.trueOrFalse
    }
}
