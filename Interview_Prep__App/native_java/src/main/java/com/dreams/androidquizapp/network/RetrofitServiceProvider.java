package com.dreams.androidquizapp.network;

import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceProvider {
    private static final String HOST = "raw.githubusercontent.com";
    private static final String PROTOCOL = "https";
    private static final String PATH =
            "/Tc2r1/DevInterview_Questions/";

    private final OkHttpProvider okHttpProvider = new OkHttpProvider();

    // In order to send out network requests to an API, I use the Retrofit builder
    // class and specify the base URL for the service.
    // I specify a factory for deserializing the response using the Gson library.
    private final Retrofit.Builder retrofitBase = new Builder()
                                                    .addConverterFactory(GsonConverterFactory.create())
                                                    .client(okHttpProvider.getClient())
            .baseUrl(String.format("%s://%s%s", PROTOCOL, HOST, PATH));


    public Tc2rGithubService tc2rGithubService =
            retrofitBase.build().create(Tc2rGithubService.class);
}


