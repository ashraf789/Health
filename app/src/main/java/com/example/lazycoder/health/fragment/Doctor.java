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
import android.view.View;
import android.view.ViewGroup;

import com.example.lazycoder.health.ModelClass.Item;
import com.example.lazycoder.health.R;
import com.example.lazycoder.health.adapter.ItemAdapter;
import com.example.lazycoder.health.databinding.FragmentDoctorBinding;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Fragment {

    private FragmentDoctorBinding binding;
    private List<Item> doctors;
    private Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_doctor, container, false);
        initializeAll();
        return binding.getRoot();
    }

    private void initializeAll() {
        doctors = new ArrayList<>();
        Item doctor;
        //sample product
        for (int  i = 0; i< 5; i++){
            doctor = new Item(
                    "Doctor No "+(1+i),
                    "Surgery",
                    "Apollo Hospital,Dhanmondi 32",
                    R.drawable.doctor2
            );

            doctors.add(doctor);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.productRV.setHasFixedSize(true);
        binding.productRV.setLayoutManager(new GridLayoutManager(context,2));

        ItemAdapter adapter = new ItemAdapter(doctors,context);
        binding.productRV.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
