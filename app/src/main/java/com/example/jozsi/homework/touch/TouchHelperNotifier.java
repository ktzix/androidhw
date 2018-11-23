package com.example.jozsi.homework.touch;

public interface TouchHelperNotifier {

    void onItemDismissed(int position);

    void onItemMoved(int fromPosition, int toPosition);
}