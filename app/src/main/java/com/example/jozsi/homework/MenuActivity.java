package com.example.jozsi.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageButton btnHistory = findViewById(R.id.btnHistory);
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent historyIntent = new Intent(MenuActivity.this, HistoryActivity.class);
                startActivity(historyIntent);
            }
        });

        ImageButton btnNewTraining = findViewById(R.id.btnNewTraining);
        btnNewTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newTrainingIntent = new Intent(MenuActivity.this, NewTrainingActivity.class);
                startActivity(newTrainingIntent);
            }
        });


    }
}
