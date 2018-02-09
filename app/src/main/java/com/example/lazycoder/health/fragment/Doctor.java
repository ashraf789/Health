package com.example.lazycoder.health.fragment;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.Toast;

import com.example.lazycoder.health.ModelClass.Item;
import com.example.lazycoder.health.R;
import com.example.lazycoder.health.activity.MainActivity;
import com.example.lazycoder.health.adapter.ItemAdapter;
import com.example.lazycoder.health.databinding.FragmentDoctorBinding;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class Doctor extends Fragment {

    private FragmentDoctorBinding binding;
    private List<Item> doctors;
    private Context context;
    private Button find_btn;
    private int PLACE_PICKER_REQUEST = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doctor, container, false);
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_doctor, container, false);
        initializeAll();
        find_btn = (Button) view.findViewById(R.id.find_button2);
        find_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maps_api();
            }
        });
        return binding.getRoot();
    }

    private void initializeAll() {
        doctors = new ArrayList<>();
        Item doctor;
        //sample product
        for (int  i = 0; i< 6; i++){
            doctor = new Item(
                    "Doctor No "+(1+i),
                    "Surgery",
                    "Apollo Hospital,Dhanmondi 32",
                    R.drawable.doctor2
            );

            doctors.add(doctor);
        }

    }

    protected void maps_api(){
        Toast.makeText(getActivity(),"ssss",Toast.LENGTH_LONG).show();
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

        try {
            startActivityForResult(builder.build(getActivity()), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
            Toast.makeText(getActivity(),"Error connecting to the server",Toast.LENGTH_LONG).show();

        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
            Toast.makeText(getActivity(),"Error connecting to the server",Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, getActivity());
                String toastMsg = String.format("Place: %s", place.getName());
                Toast.makeText(getActivity(), toastMsg, Toast.LENGTH_LONG).show();
            }
        }
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
