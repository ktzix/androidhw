package com.example.jozsi.homework.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jozsi.homework.R;
import com.example.jozsi.homework.data.WorkoutItem;
import com.example.jozsi.homework.touch.TouchHelperNotifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class WorkoutAdapter
        extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> implements TouchHelperNotifier {

    private final List<WorkoutItem> items;

    private WorkoutItemClickListener listener;
    private WorkoutItemsSwiped swipeListener;

    public WorkoutAdapter(WorkoutItemClickListener listener, WorkoutItemsSwiped swipeListener) {
        this.listener = listener;
        this.swipeListener = swipeListener;
        items = new ArrayList<>();
    }


    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_workout_list, parent, false);
        return new WorkoutViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        WorkoutItem item =items.get(position);
        holder.huzo.setText((R.string.pullups));
        holder.sumOfHuzo.setText(String.valueOf(item.huzo));
        holder.fekvo.setText((R.string.pushups));
        holder.sumOfFekvo.setText(String.valueOf(item.fekvo));
        holder.tolo.setText((R.string.dips));
        holder.sumOfTolo.setText(String.valueOf(item.tolo));
        holder.has.setText((R.string.Abs));
        holder.sumOfHas.setText(String.valueOf(item.has));

        holder.item = item;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface WorkoutItemClickListener{
        void onItemChanged(WorkoutItem item);
    }

    class WorkoutViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        TextView huzo;
        TextView fekvo;
        TextView tolo;
        TextView has;
        TextView sumOfHuzo;
        TextView sumOfFekvo;
        TextView sumOfTolo;
        TextView sumOfHas;


        WorkoutItem item;


        WorkoutViewHolder(View itemView) {
            super(itemView);

            huzo = itemView.findViewById(R.id.WorkoutItemHuzoTextView);
            sumOfHuzo= itemView.findViewById(R.id.WorkoutItemSumOfHuzoTextView);
            fekvo = itemView.findViewById(R.id.WorkoutItemFekvoTextView);
            sumOfFekvo = itemView.findViewById(R.id.WorkoutItemSumOfFekvoTextView);
            tolo = itemView.findViewById(R.id.WorkoutItemToloTextView);
            sumOfTolo = itemView.findViewById(R.id.WorkoutItemSumOfToloTextView);
            has = itemView.findViewById(R.id.WorkoutItemHasTextView);
            sumOfHas = itemView.findViewById(R.id.WorkoutItemSumOfHasTextView);

        }
    }

    public void addItem(WorkoutItem item) {
        items.add(item);
        notifyItemInserted(items.size() - 1);
    }

    public void update(List<WorkoutItem> workoutItems) {
        items.clear();
        items.addAll(workoutItems);
        notifyDataSetChanged();
    }


    public void onItemDismissed(int position) {

        WorkoutItem temp = items.get(position);

        items.remove(position);
        this.swipeListener.onWorkoutItemDeleted(temp);
        notifyItemRemoved(position);
    }

    @Override
    public void onItemMoved(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(items, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(items, i, i - 1);
            }
        }

        notifyItemMoved(fromPosition, toPosition);
    }

    public interface WorkoutItemsSwiped {
        void onWorkoutItemDeleted(WorkoutItem item);
    }



}