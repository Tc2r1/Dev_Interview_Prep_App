package com.dreams.androidquizapp.network

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/"

// Fetches JSON response. Create Retrofit Builder using scalars converter factory & give base url of web service.
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

// Implement API service interface that return JSON data as a string (through Scalars)
interface QuestionsApiService {
    // Gets answers objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/Android/questions.json")
    suspend fun getQuestionsJson():
            Response<QuestionsResponse>
}

// Creates API object using Retrofit to implement API Service
object QuestionsApi {
    val retrofitService: QuestionsApiService by lazy {
        retrofit.create(QuestionsApiService::class.java)
    }
}