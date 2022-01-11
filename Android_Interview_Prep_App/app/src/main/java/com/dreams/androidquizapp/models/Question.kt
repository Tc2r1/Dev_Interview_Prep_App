package com.dreams.androidquizapp.models

/**
 * Created by Tc2r on 5/19/2017.
 *
 *
 * Description:
 */
class Question constructor(builder: Builder) {
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
        fun shortAns(short: String): Builder {
            shortAns = short
            return this
        }

        fun trueOrFalse(tF: String): Builder {
            trueOrFalse = tF
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
