package com.example.jozsi.homework;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jozsi.homework.adapter.WorkoutAdapter;
import com.example.jozsi.homework.data.WorkoutItem;
import com.example.jozsi.homework.data.WorkoutListDatabase;

public class ResultsActivity extends AppCompatActivity  {

    EditText tolo,fekvo,huzo,has;
    Button submit;

    private WorkoutAdapter adapter;

    private WorkoutListDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        database = Room.databaseBuilder(
                getApplicationContext(),
                WorkoutListDatabase.class,
                "workout-list"
        ).build();

        tolo = (EditText) findViewById(R.id.ettolo);
        fekvo = (EditText) findViewById(R.id.etfekvo);
        huzo = (EditText) findViewById(R.id.ethuzo);
        has = (EditText) findViewById(R.id.ethas);
        submit = (Button) findViewById(R.id.btnSubmit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onWorkoutItemCreated(getWorkoutItem());
            }
        });
    }


    private WorkoutItem getWorkoutItem(){
        WorkoutItem workoutItem= new WorkoutItem();

        workoutItem.huzo = Integer.parseInt(tolo.getText().toString());
        workoutItem.has = Integer.parseInt(has.getText().toString());
        workoutItem.fekvo = Integer.parseInt(fekvo.getText().toString());
        workoutItem.tolo = Integer.parseInt(tolo.getText().toString());

        workoutItem.sumOfWorkout = Integer.parseInt(tolo.getText().toString())+
                Integer.parseInt(has.getText().toString())+
                Integer.parseInt(fekvo.getText().toString())+
                Integer.parseInt(tolo.getText().toString());


        return workoutItem;
    }

    public void onWorkoutItemCreated(final WorkoutItem newItem) {
        new AsyncTask<Void, Void, WorkoutItem>() {

            @Override
            protected WorkoutItem doInBackground(Void... voids) {
                newItem.id = database.WorkoutItemDao().insert(newItem);
                return newItem;
            }

        }.execute();
    }



}