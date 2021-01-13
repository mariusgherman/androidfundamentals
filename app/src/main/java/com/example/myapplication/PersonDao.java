package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDao {

    @Insert
    public void insert(Person person);

    @Query("SELECT * FROM Persons")
    public List<Person> getPersons();

    @Insert
    public void insertAllPersons(List<Person> personList);

    @Query("DELETE FROM Persons")
    public void deleteAll();
}
