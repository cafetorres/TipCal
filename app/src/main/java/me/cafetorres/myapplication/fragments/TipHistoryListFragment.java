package me.cafetorres.myapplication.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.cafetorres.myapplication.R;
import me.cafetorres.myapplication.activities.activity_detail;
import me.cafetorres.myapplication.adapters.OnItemClickListener;
import me.cafetorres.myapplication.adapters.TipAdapter;
import me.cafetorres.myapplication.models.TipRecord;

/**
 * Created by Carlos on 12/10/2016.
 */
public class TipHistoryListFragment extends Fragment implements TipHistoryListFragmentListener,OnItemClickListener {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    TipAdapter adapter;
    public TipHistoryListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tip_history_list, container, false);
        ButterKnife.bind(this,view);
        initAdapter();
        initRecyclerView();
        return view;
    }


    private void initAdapter() {
        if(adapter==null){
            adapter =new TipAdapter(getActivity().getApplicationContext(),this);
        }
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void addToList(TipRecord record) {
        adapter.add(record);
    }

    @Override
    public void clearList() {
        adapter.clear();
    }

    @Override
    public void onItemClick(TipRecord tipRecord) {
        Intent intent = new Intent(getActivity(),activity_detail.class);
        intent.putExtra("Total",tipRecord.getBillFormated());
        intent.putExtra("Propina",tipRecord.getTipFormated());
        intent.putExtra("Fecha", tipRecord.getDateFormated());
        startActivity(intent);

    }
}
