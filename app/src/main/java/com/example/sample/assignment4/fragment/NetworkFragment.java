package com.example.sample.assignment4.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sample.assignment4.R;
import com.example.sample.assignment4.adapter.NetworkRecyclerAdapter;
import com.example.sample.assignment4.model.Network;
import com.example.sample.assignment4.util.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darknight on 28/4/17.
 */

public class NetworkFragment extends BaseFragment {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_network, container, false);
        init(view);
        return view;
    }


    /**
     * creates list of data to be displayed in recycler view
     *
     * @return discoverList : List of data
     */
    private List<Network> getData() {
        List<Network> networkList = new ArrayList<>();

        networkList.add(new Network(R.drawable.placeholder_user,
                getString(R.string.dummy_data_city_name),
                getString(R.string.dummy_data_rating),
                Float.parseFloat(getString(R.string.dummy_data_rating))));

        networkList.add(new Network(R.drawable.placeholder_user,
                getString(R.string.dummy_data_city_name),
                getString(R.string.dummy_data_rating),
                Float.parseFloat(getString(R.string.dummy_data_rating))));

        networkList.add(new Network(R.drawable.placeholder_user,
                getString(R.string.dummy_data_city_name),
                getString(R.string.dummy_data_rating),
                Float.parseFloat(getString(R.string.dummy_data_rating))));


        return networkList;
    }


    /**
     * Intializes the view and variables
     *
     * @param view : view returned
     */
    private void init(final View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new NetworkRecyclerAdapter(getData()));
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
    }
}
