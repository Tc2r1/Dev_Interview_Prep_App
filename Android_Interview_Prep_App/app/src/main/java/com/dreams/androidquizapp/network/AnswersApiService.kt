package com.dreams.androidquizapp.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/"

// Fetches JSON response. Create Retrofit Builder using scalars converter factory & give base url of web service.
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

// Implement API service interface that return JSON data as a string (through Scalars)
interface AnswersApiService {
    // Gets answers objects
    @GET("answers")
    fun getAnswers():
        Call<String>
}

// Creates API object using Retrofit to implement API Service
object AnswersApi {
    val retrofitService: AnswersApiService by lazy {
        retrofit.create(AnswersApiService::class.java)
    }
}
