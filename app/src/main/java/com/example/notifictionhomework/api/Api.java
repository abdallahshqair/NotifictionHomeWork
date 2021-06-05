package com.example.notifictionhomework.api;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static final String BASE_URL = "https://mcc-users-api.herokuapp.com/";
    private static Api INSTANCE;
    private static APIInterface apiInterface;


    public Api(Context context) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(APIInterface.class);
    }

    public static APIInterface getApiInterface() {
        return apiInterface;
    }

    public static Api getINSTANCE(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new Api(context);
        }
        return INSTANCE;
    }
}
