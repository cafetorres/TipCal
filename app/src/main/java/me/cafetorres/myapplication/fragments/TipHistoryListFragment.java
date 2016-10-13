package me.cafetorres.myapplication.fragments;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import me.cafetorres.myapplication.R;

/**
 * Created by Carlos on 12/10/2016.
 */
public class TipHistoryListFragment extends Fragment implements TipHistoryListFragmentListener {
    public TipHistoryListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tip_history_list, container, false);
    }

    @Override
    public void action(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();

    }
}
