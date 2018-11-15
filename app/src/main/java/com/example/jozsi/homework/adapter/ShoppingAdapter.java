package com.example.jozsi.homework.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jozsi.homework.R;
import com.example.jozsi.homework.data.WorkoutItem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingAdapter
        extends RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder> {

    private final List<WorkoutItem> items;

    private ShoppingItemClickListener listener;

    public ShoppingAdapter(ShoppingItemClickListener listener) {
        this.listener = listener;
        items = new ArrayList<>();
    }

    @NonNull
    @Override
    public ShoppingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_workout_list, parent, false);
        return new ShoppingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingViewHolder holder, int position) {
        // TODO implementation
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface ShoppingItemClickListener{
        void onItemChanged(WorkoutItem item);
    }

    class ShoppingViewHolder extends RecyclerView.ViewHolder {

        ShoppingViewHolder(View itemView) {
            super(itemView);
        }
    }
}