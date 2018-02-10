package com.example.lazycoder.health.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.SearchView;

import com.example.lazycoder.health.Database.ProductDatabase;
import com.example.lazycoder.health.ModelClass.Item;
import com.example.lazycoder.health.R;
import com.example.lazycoder.health.adapter.ItemAdapter;
import com.example.lazycoder.health.databinding.FragmentDoctorBinding;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Fragment {

    private FragmentDoctorBinding binding;
    private List<Item> doctors;
    private Context context;
    ProductDatabase productDatabase;

    private int PLACE_PICKER_REQUEST = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_doctor, container, false);
        initializeAll();
        return binding.getRoot();

    }

    private final View.OnClickListener mButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            maps_api();
        }
    };

    private void maps_api(){
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

        try {
            startActivityForResult(builder.build(getActivity()), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    public View.OnClickListener getButtonClickListener() {
        return mButtonClickListener;
    }

    private void initializeAll() {
        doctors = new ArrayList<>();
        productDatabase = new ProductDatabase(context);
        doctors = productDatabase.getAllProduct("doctor");
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.doctorRV.setHasFixedSize(true);
        binding.doctorRV.setLayoutManager(new GridLayoutManager(context,2));

        ItemAdapter adapter = new ItemAdapter(doctors,context);
        binding.doctorRV.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }


}
