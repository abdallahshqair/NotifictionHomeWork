package com.example.notifictionhomework.api;

import com.example.notifictionhomework.CreateUser;
import com.example.notifictionhomework.Login;
import com.example.notifictionhomework.Result;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {
    @POST("login")
    Call<Result> login(@Body Login body);

    @POST("add_new_user")
    Call<Result> signup(@Body CreateUser body);

    @POST("add_reg_token")
    Call<String> token(@Body String body);
}
