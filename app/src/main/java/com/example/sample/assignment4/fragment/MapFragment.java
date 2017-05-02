package com.example.sample.assignment4.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sample.assignment4.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by darknight on 30/4/17.
 */

public class MapFragment extends BaseFragment implements OnMapReadyCallback {
    private GoogleMap mMap;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        View view;
        Fragment fragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_map);
        view = inflater.inflate(R.layout.fragment_maps, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager()
                .findFragmentById(R.id.fragment_map);

        return view;
    }


    /**
     * Called when map is ready to be used
     *
     * @param googleMap : Reference of the map loaded
     */
    @Override
    public void onMapReady(final GoogleMap googleMap) {
        if (googleMap != null) {
            mMap = googleMap;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Fragment fragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_map);
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }

}
