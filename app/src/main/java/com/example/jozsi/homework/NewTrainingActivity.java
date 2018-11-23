package com.example.jozsi.homework;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class NewTrainingActivity extends AppCompatActivity {

    Chronometer chronometer;
    Button start, stop, results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_training);

        results = findViewById(R.id.btnResults);
        start = findViewById(R.id.startButton);
        stop = findViewById(R.id.stopButton);
        chronometer = findViewById(R.id.simpleChronometer);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                results.setVisibility(View.GONE);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chronometer.stop();
                results.setVisibility(View.VISIBLE);
            }
        });

        results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultsIntent = new Intent(NewTrainingActivity.this, ResultsActivity.class);
                startActivity(resultsIntent);

            }
        });

    }
}
