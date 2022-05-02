package com.dreams.androidquizapp.network;

import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;

import static java.util.concurrent.TimeUnit.SECONDS;

public class OkHttpProvider{
    private static final int WRITE_TIMEOUT = 60;
    private static final int READ_TIMEOUT = 180;
    private static final int CONNECT_TIMEOUT = 90;

    public OkHttpClient getClient() {
        Builder okBuilder = new Builder()
                .writeTimeout(WRITE_TIMEOUT, SECONDS)
                .readTimeout(READ_TIMEOUT, SECONDS)
                .connectTimeout(CONNECT_TIMEOUT, SECONDS);

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(Level.BODY);

        return okBuilder.build();
    }
}
