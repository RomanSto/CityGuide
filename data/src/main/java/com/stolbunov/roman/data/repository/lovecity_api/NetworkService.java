package com.stolbunov.roman.data.repository.lovecity_api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static final String BASE_URL = "http://lovecity.net.ua/api/";
    private final Retrofit retrofit;

    public NetworkService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public ILovecityHolderApi getLovecityApi() {
        return retrofit.create(ILovecityHolderApi.class);
    }
}
