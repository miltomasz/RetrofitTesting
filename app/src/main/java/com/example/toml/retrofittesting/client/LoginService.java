package com.example.toml.retrofittesting.client;

import com.example.toml.retrofittesting.model.User;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by toml on 08.04.16.
 */
public interface LoginService {

    @POST("/login")
    Call<User> basicLogin();
}
