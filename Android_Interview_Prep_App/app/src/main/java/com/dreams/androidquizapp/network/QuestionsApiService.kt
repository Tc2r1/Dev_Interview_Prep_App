package com.dreams.androidquizapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/"

//Use Moshi Builder to create Moshi object w. KotlinJsonAdapterFactory
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// Fetches JSON response. Create Retrofit Builder using scalars converter factory & give base url of web service.
private val retrofit = Retrofit.Builder()
    //Turns Json response into string
    //.addConverterFactory(ScalarsConverterFactory.create())
    //Turns Json response into Kotlin Objects
    //.addConverterFactory(MoshiConverterFactory.create(moshi))
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

// Implement API service interface that return JSON data as a string (through Scalars)
interface QuestionsApiService {
    // Gets answers objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/Android/questions.json")
    fun getQuestionsJson():
            Call<QuestionsResponse>
}

// Creates API object using Retrofit to implement API Service
object QuestionsApi {
    val retrofitService: QuestionsApiService by lazy {
        retrofit.create(QuestionsApiService::class.java)
    }
}