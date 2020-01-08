package com.example.myapplication;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataSource {

    private final Context context;
    private final PersonDatabase personDatabase;

    private Retrofit retrofit;

    public DataSource(Context context) {
        this.context = context;
        this.personDatabase = PersonDatabase.getDatabase(context);
    }

    public List<Object> getServerDataSource(final MainActivity mainActivity) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                PersonDao personDao = personDatabase.personDao();
                List<PersonEntity> personsInDb = personDao.getPersons();
                if (!personsInDb.isEmpty()) {
                    List<String> nameList = new ArrayList<>();
                    for (PersonEntity person : personsInDb) {
                        nameList.add(person.name + " " + person.surname);
                    }
                    mainActivity.setNamesList(nameList);
                } else {
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
                                for (Person person : serverPeople) {
                                    nameList.add(person.name + " " + person.surname);
                                }
                                mainActivity.setNamesList(nameList);

                                saveToDb(serverPeople);
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Person>> call, Throwable t) {

                        }
                    });
                }
            }
        }).start();

        return null;
    }

    private void saveToDb(final List<Person> personList) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                PersonDao personDao = personDatabase.personDao();
                List<PersonEntity> personEntities = new ArrayList<>();
                for (Person person : personList) {
                    PersonEntity personEntity = new PersonEntity();
                    personEntity.setName(person.getName());
                    personEntity.setSurname(person.getSurname());
                    personEntity.setHomeAddress(person.getHomeAddress());

                    personEntities.add(personEntity);
                }

                personDao.saveAllPersons(personEntities);
            }
        }).start();
    }
}
