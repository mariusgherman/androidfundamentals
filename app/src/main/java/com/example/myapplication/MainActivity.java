package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://raw.githubusercontent.com/";
    private static Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersonApi api = getRetrofit().create(PersonApi.class);
        Call<List<Person>> persons = api.getPersons("test_json2");
        persons.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, final Response<List<Person>> response) {
                if (response.isSuccessful()) {
                    Log.d("Response", response.body().toString());

                    new Thread() {
                        @Override
                        public void run() {

                            ArrayList<PersonEntity> personEntities = new ArrayList<>();
                            for (Person person : response.body()) {
                                personEntities.add(new PersonEntity(
                                        person.getName(),
                                        person.getSurname(),
                                        person.getHomeAddress()
                                ));
                            }

                            Database.getDatabase(MainActivity.this).personDao()
                                    .insertPersons(personEntities);
                        }
                    }.start();


                } else {

                    Log.d("Response", "Response code " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                Log.w("Response", "Error in call", t);
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        List<PersonEntity> personEntities = Database
                                .getDatabase(MainActivity.this)
                                .personDao()
                                .getAllPersons();

                        Log.d("Persons", "The persons are " + personEntities.toString());
                    }
                }.start();

            }
        });
    }

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
