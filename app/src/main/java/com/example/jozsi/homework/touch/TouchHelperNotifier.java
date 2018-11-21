package com.example.jozsi.homework.touch;

public interface TouchHelperNotifier {

    public void onItemDismissed(int position);

    public void onItemMoved(int fromPosition, int toPosition);
}