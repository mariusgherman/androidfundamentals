package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataSource {

    private Retrofit retrofit;

    public List<Object> getServerDataSource(final MainActivity mainActivity) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        retrofitApi.getPersons().enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                if (response.isSuccessful()) {
                    List<Person> serverPeople = response.body();
                    List<String> nameList = new ArrayList<>();
                    for (Person person :serverPeople) {
                        nameList.add(person.name + " " + person.surname);
                    }
                    mainActivity.setNamesList(nameList);
                }
            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {

            }
        });

        return null;
    }
}
