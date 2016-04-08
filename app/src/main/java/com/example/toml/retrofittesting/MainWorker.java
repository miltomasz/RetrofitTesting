package com.example.toml.retrofittesting;

import com.example.toml.retrofittesting.model.User;
import com.example.toml.retrofittesting.client.LoginService;
import com.example.toml.retrofittesting.service.ServiceGenerator;

import java.io.IOException;

import retrofit2.Call;


/**
 * Created by toml on 08.04.16.
 */
public class MainWorker {

    public static void main(String... args) throws IOException {
        // Create a very simple REST adapter which points the GitHub API endpoint.
//        GitHubClient client = ServiceGenerator.createService(GitHubClient.class);
//
//        // Fetch and print a list of the contributors to this library.
//        Call<List<Contributor>> call = client.contributors("aaronpeterson", "jquery-tokeninput");
//
//        List<Contributor> contributors = null;
//        try {
//            contributors = call.execute().body();
//        } catch (IOException e) {
//            // handle errors
//        }
//
//        for (Contributor contributor : contributors) {
//            System.out.println(contributor.getLogin() + " (" + contributor.getContributions() + ")");
//        }

        LoginService loginService = ServiceGenerator.createService(LoginService.class, "miltomasz", "balon9010");
        Call<User> call = loginService.basicLogin();

        User user = call.execute().body();
        System.out.println(user);

    }
}
