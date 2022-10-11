package com.interviewprep.template.repository.tc2rgithubrepository.source.remote

import com.interviewprep.template.repository.models.response.AnswersResponse
import com.interviewprep.template.repository.models.response.QuestionsResponse

internal interface Tc2rGithubService {
    // Request method and URL specified in the annotation

    // FIXME: Use your own preference to make request to the api
    fun getAnswers(onAnswersReceived: (AnswersResponse?, Throwable?) -> Unit) {
        onAnswersReceived(AnswersResponse(), null)
    }

    // FIXME: Gets answers objects
    fun getQuestions(onQuestionsReceived: (QuestionsResponse?, Throwable?) -> Unit) {
        onQuestionsReceived(QuestionsResponse(), null)
    }

    // Add any other request you'd like app to make as well.
}
