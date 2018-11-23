package com.example.jozsi.homework;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import com.example.jozsi.homework.adapter.WorkoutAdapter;
import com.example.jozsi.homework.data.WorkoutItem;
import com.example.jozsi.homework.data.WorkoutListDatabase;
import com.example.jozsi.homework.touch.TodoItemTouchHelperCallback;

import java.util.List;

public class HistoryActivity extends AppCompatActivity implements WorkoutAdapter.WorkoutItemClickListener, WorkoutAdapter.WorkoutItemsSwiped{

    private RecyclerView recyclerView;
    private WorkoutAdapter adapter;

    private WorkoutListDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);



        database = Room.databaseBuilder(
                getApplicationContext(),
                WorkoutListDatabase.class,
                "workout-list"
        ).build();




        initRecyclerView();

        ItemTouchHelper.Callback callback =
                new TodoItemTouchHelperCallback(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.MainRecyclerView);
        adapter = new WorkoutAdapter(this, this);
        loadItemsInBackground();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @SuppressLint("StaticFieldLeak")
    private void loadItemsInBackground() {
        new AsyncTask<Void, Void, List<WorkoutItem>>() {

            @Override
            protected List<WorkoutItem> doInBackground(Void... voids) {
                return database.WorkoutItemDao().getAll();
            }

            @Override
            protected void onPostExecute(List<WorkoutItem> shoppingItems) {
                adapter.update(shoppingItems);
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    @Override
    public void onItemChanged(final WorkoutItem item) {
        new AsyncTask<Void, Void, Boolean>() {

            @Override
            protected Boolean doInBackground(Void... voids) {
                database.WorkoutItemDao().update(item);
                return true;
            }

            @Override
            protected void onPostExecute(Boolean isSuccessful) {
                Log.d("HistoryActivity", "ShoppingItem update was successful");
            }
        }.execute();
    }


    @SuppressLint("StaticFieldLeak")
    @Override
    public void onWorkoutItemDeleted(final WorkoutItem item) {
        new AsyncTask<Void, Void, WorkoutItem>() {

            @Override
            protected WorkoutItem doInBackground(Void... voids) {
                database.WorkoutItemDao().deleteItem(item);
                return item;
            }

        }.execute();
    }
}
