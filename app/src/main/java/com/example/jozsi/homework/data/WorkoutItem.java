package com.example.jozsi.homework.data;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

import java.util.Date;

@Entity(tableName = "workoutitem")
public class WorkoutItem {

    @ColumnInfo(name = "id")
    public Long id;

    @ColumnInfo(name= "WorkoutName")
    public String name;

    @ColumnInfo(name = "Date")
    public Date date;

   @ColumnInfo(name= "Fekvo")
    public String fekvo;

    @ColumnInfo(name= "SumOfFekvo")
    public String sumOfFekvo;

    @ColumnInfo(name= "Huzo")
    public String huzo;

    @ColumnInfo(name= "SumOfHuzo")
    public String sumOfHuzo;

    @ColumnInfo(name= "Tolo")
    public String tolo;

    @ColumnInfo(name= "SumOfTolo")
    public String sumOfTolo;

    @ColumnInfo(name= "Has")
    public String Has;

    @ColumnInfo(name= "SumOfHas")
    public String sumOfHas;

    @ColumnInfo(name = "SumOfWorkout")
    public int sumOfWorkout;

}
