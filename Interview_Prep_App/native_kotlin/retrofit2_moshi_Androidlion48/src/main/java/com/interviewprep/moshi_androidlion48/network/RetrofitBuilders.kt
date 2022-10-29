package com.interviewprep.moshi_androidlion48.network

import com.interviewprep.moshi_androidlion48.repository.tc2rgithubrepository.source.remote.Tc2rGithubService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit.Builder
import retrofit2.converter.moshi.MoshiConverterFactory

// TODO: Use this class to fetch and convert the json information. You don't have to use retrofit
// You can use a similar library to create a service.
class RetrofitBuilders {
    companion object {
        private const val BASE_URL = "https://raw.githubusercontent.com/"
    }

    private val okHttpProvider = OkHttpProvider()
    private val buildClient = okHttpProvider.client

    // Fetches JSON response. Create Retrofit Builder using Moshi converter factory & give base url of web service.
    // In order to send out network requests to an API, I use the Retrofit builder
    // class and specify the base URL for the service.
    // Initialize/ build the Moshi converter translating the response using the Moshi library.
    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    private val buildRetrofit = Builder()
        .client(buildClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()


    internal val tc2rGithubService: Tc2rGithubService by lazy {
        buildRetrofit.create(Tc2rGithubService::class.java)
    }
}
