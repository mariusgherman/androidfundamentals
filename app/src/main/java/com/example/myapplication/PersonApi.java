package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PersonApi {

    @GET("/mariusgherman/androidfundamentals/weeks/week8/{json}")
    Call<List<Person>> getPersons(@Path("json") String jsonToFetch);

}
