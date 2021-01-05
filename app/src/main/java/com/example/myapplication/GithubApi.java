package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubApi {

    @GET("/mariusgherman/androidfundamentals/weeks/week8/test_json1")
    Call<List<Person>> getPersons();

}
