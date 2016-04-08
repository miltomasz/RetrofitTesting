package com.example.toml.retrofittesting.client;

import com.example.toml.retrofittesting.model.Contributor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by toml on 08.04.16.
 */
public interface GitHubClient {

    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> contributors(@Path("owner") String owner, @Path("repo") String repo);
}