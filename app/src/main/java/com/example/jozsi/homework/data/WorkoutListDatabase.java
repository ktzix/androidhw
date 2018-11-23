package com.example.jozsi.homework.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(
        entities = {WorkoutItem.class},
        version = 1
)

public abstract class WorkoutListDatabase extends RoomDatabase {
    public abstract WorkoutItemDao WorkoutItemDao();
}




