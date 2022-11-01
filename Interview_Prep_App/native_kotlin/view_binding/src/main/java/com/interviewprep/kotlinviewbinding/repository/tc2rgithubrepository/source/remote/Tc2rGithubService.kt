package com.interviewprep.kotlinviewbinding.repository.tc2rgithubrepository.source.remote

import com.interviewprep.kotlinviewbinding.repository.models.response.AnswersResponse
import com.interviewprep.kotlinviewbinding.repository.models.response.QuestionsResponse
import retrofit2.Response
import retrofit2.http.GET

internal interface Tc2rGithubService {
    // Request method and URL specified in the annotation

    @GET("Tc2r1/DevInterview_Questions/master/Languages/Android/answers.json")
    suspend fun requestAnswers(): Response<AnswersResponse>

    // Gets answers objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/Android/questions.json")
    suspend fun getQuestionsJson(): Response<QuestionsResponse>
}
