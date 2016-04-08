package com.example.toml.retrofittesting.model;

/**
 * Created by toml on 08.04.16.
 */
public class Contributor {
    String login;
    int contributions;

    public String getLogin() {
        return login;
    }

    public int getContributions() {
        return contributions;
    }

    @Override
    public String toString() {
        return "Contributor{" +
                "login='" + login + '\'' +
                ", contributions=" + contributions +
                '}';
    }
}
