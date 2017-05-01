package com.example.sample.assignment4.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sample.assignment4.R;
import com.example.sample.assignment4.adapter.RequestRecyclerAdapter;
import com.example.sample.assignment4.model.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darknight on 28/4/17.
 */

public class RequestsFragment extends BaseFragment {
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        init(view);
        return view;
    }

    /**
     * creates list of data to be displayed in recycler view
     *
     * @return discoverList : List of data
     */
    private List<Request> getData() {
        List<Request> requestList = new ArrayList<>();

        requestList.add(new Request(getString(R.string.dummy_data_name),
                getString(R.string.dummy_data_address),
                getString(R.string.dummy_data_text),
                getString(R.string.dummy_data_rating),
                Float.parseFloat(getString(R.string.dummy_data_rating))));
        requestList.add(new Request(getString(R.string.dummy_data_name),
                getString(R.string.dummy_data_address),
                getString(R.string.dummy_data_text),
                getString(R.string.dummy_data_rating),
                Float.parseFloat(getString(R.string.dummy_data_rating))));
        requestList.add(new Request(getString(R.string.dummy_data_name),
                getString(R.string.dummy_data_address),
                getString(R.string.dummy_data_text),
                getString(R.string.dummy_data_rating),
                Float.parseFloat(getString(R.string.dummy_data_rating))));


        return requestList;
    }


    /**
     * Intializes the view and variables
     *
     * @param view : view returned
     */
    private void init(final View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new RequestRecyclerAdapter(getData()));
    }
}
