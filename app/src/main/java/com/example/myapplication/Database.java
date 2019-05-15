package com.example.myapplication;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@android.arch.persistence.room.Database(entities = {PersonEntity.class}, version = 1)
public abstract class Database extends RoomDatabase {

    public abstract PersonDao personDao();

    private static Database DATABASE;

    public static Database getDatabase(Context context) {
        if (DATABASE == null) {
            DATABASE = Room.databaseBuilder(context,
                    Database.class,
                    "my_database")
                    .build();
        }
        return DATABASE;
    }

}
