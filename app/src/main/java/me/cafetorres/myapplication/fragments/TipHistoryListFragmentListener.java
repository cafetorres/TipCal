package me.cafetorres.myapplication.fragments;

import me.cafetorres.myapplication.models.TipRecord;

/**
 * Created by Carlos on 12/10/2016.
 */

public interface TipHistoryListFragmentListener {
    void addToList(TipRecord record);
    void clearList();
}
