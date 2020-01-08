package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDao {

    @Query("SELECT * FROM Person")
    List<PersonEntity> getPersons();

    @Insert
    void savePerson(PersonEntity personEntity);

    @Insert
    void saveAllPersons(List<PersonEntity> personEntities);

}
