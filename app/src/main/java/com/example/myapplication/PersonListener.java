package com.example.myapplication;

import java.util.List;

public interface PersonListener {

    public void onPersonsFetchedFromServer(List<Person> personList);

}
