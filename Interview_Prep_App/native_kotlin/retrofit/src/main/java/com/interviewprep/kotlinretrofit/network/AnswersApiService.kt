package com.interviewprep.kotlinretrofit.network

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/"

// Fetches JSON response. Create Retrofit Builder using scalars converter factory & give base url of web service.
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

// Implement API service interface that return JSON data as a string (through Scalars)
interface AnswersApiService {
    @GET("Tc2r1/DevInterview_Questions/master/Languages/Android/answers.json")
    suspend fun requestAnswers():
        Response<AnswersResponse>
}

// Creates API object using Retrofit to implement API Service
object AnswersApi {
    val retrofitService: AnswersApiService by lazy {
        retrofit.create(AnswersApiService::class.java)
    }
}
