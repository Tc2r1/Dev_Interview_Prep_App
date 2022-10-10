package com.interviewprep.kotlinretrofit.network

import com.interviewprep.kotlinretrofit.repository.tc2rgithubrepository.source.remote.Tc2rGithubService
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilders {
    companion object {
        private const val BASE_URL = "https://raw.githubusercontent.com/"
    }

    private val okHttpProvider = OkHttpProvider()
    private val buildClient = okHttpProvider.client

    // Fetches JSON response. Create Retrofit Builder using Gson converter factory & give base url of web service.
    // In order to send out network requests to an API, I use the Retrofit builder
    // class and specify the base URL for the service.
    // I specify a factory for deserializing the response using the Gson library.
    private val buildRetrofit = Builder()
        .client(buildClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    internal var tc2rGithubService = buildRetrofit.create(Tc2rGithubService::class.java)
}
