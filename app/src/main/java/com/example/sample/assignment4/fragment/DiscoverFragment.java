package com.example.sample.assignment4.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sample.assignment4.AppConstants;
import com.example.sample.assignment4.R;
import com.example.sample.assignment4.activity.NavigationActivity;
import com.example.sample.assignment4.adapter.DiscoverRecyclerAdapter;
import com.example.sample.assignment4.model.Discover;
import com.example.sample.assignment4.util.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darknight on 28/4/17.
 */

public class DiscoverFragment extends BaseFragment implements NavigationActivity.OnRecyclerLayoutChange {
    private RecyclerView recyclerView;
    private ImageButton imageButtonChangeLayout;
    private int mode;
    private boolean isGridView = false;
    private DiscoverRecyclerAdapter mDiscoverRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        init(view);
        return view;
    }

    /**
     * Intializes the view and variables
     *
     * @param view : view returned
     */
    private void init(final View view) {
        mode = getArguments().getInt("mode");
        Log.d("DiscoverFragment", "init: " + mode);
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_rv);
        imageButtonChangeLayout = (ImageButton) view.findViewById(R.id.toolbar_ib_grid);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mDiscoverRecyclerAdapter = new DiscoverRecyclerAdapter(getData(), mode);
        recyclerView.setAdapter(mDiscoverRecyclerAdapter);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.grid_layout_margin);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, spacingInPixels, true, 0));
        recyclerView.requestFocus();
    }

    /**
     * creates list of data to be displayed in recycler view
     *
     * @return discoverList : List of data
     */
    private List<Discover> getData() {
        List<Discover> discoverList = new ArrayList<>();
        if (mode == AppConstants.MODE_ADAPTER_DISCOVER) {
            Toast.makeText(getActivity(), "if", Toast.LENGTH_SHORT).show();
            discoverList.add(new Discover(getString(R.string.dummy_data_city_name),
                    getString(R.string.dummy_data_name),
                    getString(R.string.dummy_data_duration),
                    getString(R.string.dummy_data_review),
                    getString(R.string.dummy_data_text),
                    Float.parseFloat(getString(R.string.dummy_data_rating))));
            discoverList.add(new Discover(getString(R.string.dummy_data_city_name),
                    getString(R.string.dummy_data_name),
                    getString(R.string.dummy_data_duration),
                    getString(R.string.dummy_data_review),
                    getString(R.string.dummy_data_text),
                    Float.parseFloat(getString(R.string.dummy_data_rating))));
            discoverList.add(new Discover(getString(R.string.dummy_data_city_name),
                    getString(R.string.dummy_data_name),
                    getString(R.string.dummy_data_duration),
                    getString(R.string.dummy_data_review),
                    getString(R.string.dummy_data_text),
                    Float.parseFloat(getString(R.string.dummy_data_rating))));
            discoverList.add(new Discover(getString(R.string.dummy_data_city_name),
                    getString(R.string.dummy_data_name),
                    getString(R.string.dummy_data_duration),
                    getString(R.string.dummy_data_review),
                    getString(R.string.dummy_data_text),
                    Float.parseFloat(getString(R.string.dummy_data_rating))));
            discoverList.add(new Discover(getString(R.string.dummy_data_city_name),
                    getString(R.string.dummy_data_name),
                    getString(R.string.dummy_data_duration),
                    getString(R.string.dummy_data_review),
                    getString(R.string.dummy_data_text),
                    Float.parseFloat(getString(R.string.dummy_data_rating))));
        } else if (mode == AppConstants.MODE_ADAPTER_MY_POSTS) {
            Toast.makeText(getActivity(), "elseif", Toast.LENGTH_SHORT).show();
            discoverList.add(new Discover(getString(R.string.dummy_data_city_name),
                    getString(R.string.dummy_data_duration),
                    getString(R.string.dummy_data_review),
                    getString(R.string.dummy_data_text)));
            discoverList.add(new Discover(getString(R.string.dummy_data_city_name),
                    getString(R.string.dummy_data_duration),
                    getString(R.string.dummy_data_review),
                    getString(R.string.dummy_data_text)));
        } else {
            Toast.makeText(getActivity(), "Invalid Data", Toast.LENGTH_SHORT).show();
        }

        return discoverList;
    }

    /**
     * Returns reference of @{@link DiscoverFragment}
     *
     * @param mode : whether Discover Fragment or My Posts
     * @return : reference of @{@link DiscoverFragment}
     */
    public static DiscoverFragment getInstance(final int mode) {
        Bundle bundle = new Bundle();
        DiscoverFragment discoverFragment = new DiscoverFragment();
        bundle.putInt("mode", mode);
        Log.d("DiscoverFragment", "getInstance: " + mode);
        discoverFragment.setArguments(bundle);
        return discoverFragment;

    }


    @Override
    public void onRecyclerLayoutChange(final boolean isGridViewEnabled) {
        if (isGridViewEnabled) {
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        }
        mDiscoverRecyclerAdapter.setGridView(isGridViewEnabled);
        mDiscoverRecyclerAdapter.notifyDataSetChanged();
    }
}


