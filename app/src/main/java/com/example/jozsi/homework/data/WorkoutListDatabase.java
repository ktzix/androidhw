package com.example.jozsi.homework.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.Update;

import java.util.List;

@Database(
        entities = {WorkoutItem.class},
        version = 1
)

public abstract class WorkoutListDatabase extends RoomDatabase {
    public abstract WorkoutItem shoppingItemDao();
}




