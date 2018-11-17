package com.example.jozsi.homework.data;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "workoutitem")
public class WorkoutItem {

    @PrimaryKey
    @ColumnInfo(name = "id")
    public Long id;

    @ColumnInfo(name= "WorkoutName")
    public String name;


   @ColumnInfo(name= "Fekvo")
    public Integer fekvo;


    @ColumnInfo(name= "Huzo")
    public Integer huzo;

    @ColumnInfo(name= "Tolo")
    public String tolo;


    @ColumnInfo(name= "Has")
    public Integer has;


    @ColumnInfo(name = "SumOfWorkout")
    public int sumOfWorkout;

}
