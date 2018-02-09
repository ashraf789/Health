package com.example.lazycoder.health.fragment;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        RecommendedProduct product;

        //sample product
        for (int  i = 0; i< 5; i++){
            product = new RecommendedProduct(
                    "Doctor No "+(1+i),
                    "Surgery",
                    "Apollo Hospital,Dhanmondi 32",
                    R.drawable.doctor2
            );

            doctor.add(product);
        }

        for (int  i = 0; i< 5; i++){
            product = new RecommendedProduct(
                    "Accessorise No "+(1+i),
                    "Asteva MrI",
                    "Matro shoping center, Shukrabad",
                    R.drawable.accessoris2
            );

            accessorise.add(product);
        }

        for (int  i = 0; i< 5; i++){
            product = new RecommendedProduct(
                    "Medicine Shop No "+(1+i),
                    "Hog Medicine",
                    "Dhanmondi 2, Road 02",
                    R.drawable.medicineshop
            );

            medicine.add(product);
        }

        //start adding foods
        for (int  i = 0; i< 5; i++){
            product = new RecommendedProduct(
                    "Organic Honey "+(i+1),
                    "no added preservatives",
                    "Narayan gonj",
                    R.drawable.honey
            );
            food.add(product);
        }

        //end

        for (int  i = 0; i< 5; i++){
            product = new RecommendedProduct(
                    "Gym No "+(1+i),
                    "Hi Five Gym",
                    "Dhanmondi 1,Road 03",
                    R.drawable.gymcenter
            );

            gym.add(product);
        }

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
