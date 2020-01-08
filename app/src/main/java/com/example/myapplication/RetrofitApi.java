package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {

    @GET("mariusgherman/androidfundamentals/weeks/week8/test_json2")
    Call<List<Person>> getPersons();

}
