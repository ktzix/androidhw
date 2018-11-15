package com.example.jozsi.homework.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface WorkoutItemDao {
    @Query("SELECT * FROM workoutitem")
    List<WorkoutItem> getAll();


    @Insert
    long insert(WorkoutItem shoppingItems);

    @Update
    void update(WorkoutItem shoppingItem);

    @Delete
    void deleteItem(WorkoutItem shoppingItem);
}
