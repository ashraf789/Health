package com.example.lazycoder.health.fragment;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lazycoder.health.Database.ProductDatabase;
import com.example.lazycoder.health.ModelClass.RecommendedProduct;
import com.example.lazycoder.health.R;
import com.example.lazycoder.health.adapter.RecommendedProductAdapter;
import com.example.lazycoder.health.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment{


    private FragmentHomeBinding binding;
    private List<RecommendedProduct> doctor;
    private List<RecommendedProduct> accessorise;
    private List<RecommendedProduct> medicine;
    private List<RecommendedProduct> food;
    private List<RecommendedProduct> gym;
    ProductDatabase productDatabase;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false);
        initializeAll();
        return  binding.getRoot();
    }

    private void initializeAll() {
        doctor = new ArrayList<>();
        accessorise = new ArrayList<>();
        medicine = new ArrayList<>();
        food = new ArrayList<>();
        gym = new ArrayList<>();

        productDatabase = new ProductDatabase(context);

        RecommendedProduct product;

        //sample product

        doctor = productDatabase.getAllProductRecommendedFormat("doctor");
        accessorise = productDatabase.getAllProductRecommendedFormat("fitness");
        medicine = productDatabase.getAllProductRecommendedFormat("medicine");
        gym = productDatabase.getAllProductRecommendedFormat("gym");
        food = productDatabase.getAllProductRecommendedFormat("food");


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.doctorRV.setHasFixedSize(true);
        binding.doctorRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        binding.accessoriesRV.setHasFixedSize(true);
        binding.accessoriesRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        binding.medicineRV.setHasFixedSize(true);
        binding.medicineRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        binding.foodRV.setHasFixedSize(true);
        binding.foodRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        binding.gymRV.setHasFixedSize(true);
        binding.gymRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        RecommendedProductAdapter adapterDoctor = new RecommendedProductAdapter(doctor,context);
        RecommendedProductAdapter adapterAccessorise = new RecommendedProductAdapter(accessorise,context);
        RecommendedProductAdapter adapterMedicine = new RecommendedProductAdapter(medicine,context);
        RecommendedProductAdapter adapterFood = new RecommendedProductAdapter(food,context);
        RecommendedProductAdapter adapterGym = new RecommendedProductAdapter(gym,context);


        binding.doctorRV.setAdapter(adapterDoctor);
        binding.accessoriesRV.setAdapter(adapterAccessorise);
        binding.medicineRV.setAdapter(adapterMedicine);
        binding.foodRV.setAdapter(adapterFood);
        binding.gymRV.setAdapter(adapterGym);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

}
