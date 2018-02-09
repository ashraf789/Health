package com.example.lazycoder.health.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lazycoder.health.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddressMapView extends Fragment {


    public AddressMapView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_address_map_view, container, false);
    }

}
