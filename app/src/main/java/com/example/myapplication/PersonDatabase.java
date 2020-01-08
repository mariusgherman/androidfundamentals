package com.example.myapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {PersonEntity.class}, version = 1)
public abstract class PersonDatabase extends RoomDatabase {

    public abstract PersonDao personDao();

    private static PersonDatabase INSTANCE;

    public static PersonDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, PersonDatabase.class, "person-db")
                    .build();
        }

        return INSTANCE;
    }

}
