package com.example.jozsi.homework.data;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "workoutitem")
public class WorkoutItem {

    @PrimaryKey
    @ColumnInfo(name = "id")
    public Long id;



   @ColumnInfo(name= "Fekvo")
    public Integer fekvo;


    @ColumnInfo(name= "Huzo")
    public Integer huzo;

    @ColumnInfo(name= "Tolo")
    public Integer tolo;


    @ColumnInfo(name= "Has")
    public Integer has;




}
