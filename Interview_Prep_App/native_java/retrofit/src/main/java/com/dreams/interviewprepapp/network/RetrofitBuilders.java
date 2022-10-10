package com.dreams.interviewprepapp.network;

import com.dreams.interviewprepapp.repositories.tc2rgithubrepository.source.remote.Tc2rGithubService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilders {
    private static final String HOST = "raw.githubusercontent.com";
    private static final String PROTOCOL = "https";
    private static final String PATH =
            "/Tc2r1/DevInterview_Questions/";

    private final OkHttpProvider okHttpProvider = new OkHttpProvider();
    private final okhttp3.OkHttpClient buildClient = okHttpProvider.getClient();


    // In order to send out network requests to an API, I use the Retrofit builder
    // class and specify the base URL for the service.
    // I specify a factory for deserializing the response using the Gson library.
    private final Retrofit buildRetrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(buildClient)
            .baseUrl(String.format("%s://%s%s", PROTOCOL, HOST, PATH))
            .build();



    public Tc2rGithubService tc2rGithubService =
            buildRetrofit.create(Tc2rGithubService.class);
}
