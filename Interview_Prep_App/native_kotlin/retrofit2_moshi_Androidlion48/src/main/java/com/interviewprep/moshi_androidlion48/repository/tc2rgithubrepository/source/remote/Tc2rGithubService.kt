package com.interviewprep.moshi_androidlion48.repository.tc2rgithubrepository.source.remote

import com.interviewprep.moshi_androidlion48.repository.models.response.AnswersResponse
import com.interviewprep.moshi_androidlion48.repository.models.response.QuestionsResponse
import retrofit2.Response
import retrofit2.http.GET

internal interface Tc2rGithubService {
    // Request method and URL specified in the annotation

    // FIXME: Use your own preference to make request to the api
    @GET("Tc2r1/DevInterview_Questions/master/Languages/Android/answers.json")
    suspend fun getAnswersResponse(): Response<AnswersResponse>

    @GET("Tc2r1/DevInterview_Questions/master/Languages/Android/questions.json")
    suspend fun getQuestionsResponse(): Response<QuestionsResponse>
}

// Add any other request you'd like app to make as well.
