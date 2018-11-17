package com.example.jozsi.homework.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;

import com.example.jozsi.homework.data.WorkoutItem;

public class WorkoutItemDialogFragment extends DialogFragment {

    public static final String TAG = "NewWorkoutItemDialogListener";

    public interface NewShoppingItemDialogListener {
        void onShoppingItemCreated(WorkoutItem newItem);
    }

    private NewShoppingItemDialogListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity instanceof NewShoppingItemDialogListener) {
            listener = (NewShoppingItemDialogListener) activity;
        } else {
            throw new RuntimeException("Activity must implement the NewShoppingItemDialogListener interface!");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireActivity()).create();
    }
}
