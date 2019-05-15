package com.example.myapplication;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public abstract class PersonDao {

    @Query("SELECT * FROM Person")
    public abstract List<PersonEntity> getAllPersons();

    @Transaction
    public void insertPersons(List<PersonEntity> personList) {
        deleteAll();
        insertThePersons(personList);
    }

    @Insert
    public abstract void insertThePersons(List<PersonEntity> personEntityList);

    @Query("DELETE FROM Person")
    public abstract void deleteAll();

    @Update
    public abstract void updatePersons(List<PersonEntity> personEntityList);

    @Delete
    public abstract void delete(PersonEntity person);

}
