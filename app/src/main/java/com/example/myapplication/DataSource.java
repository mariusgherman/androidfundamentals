package com.example.myapplication;

import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataSource {

    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public void getPersons(PersonListener listener) {
        GithubApi githubApi = getRetrofit().create(GithubApi.class);
        githubApi.getPersons()
                .enqueue(new Callback<List<Person>>() {
                    @Override
                    public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                        if (response.isSuccessful()) {
                            Log.d("tag", "response was successful");
                            listener.onPersonsFetchedFromServer(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Person>> call, Throwable throwable) {
                        Log.d("tag", "response was failed");
                    }
                });
    }
}
