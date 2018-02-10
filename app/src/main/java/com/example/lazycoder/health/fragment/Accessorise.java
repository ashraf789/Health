package com.example.lazycoder.health.fragment;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lazycoder.health.Database.ProductDatabase;
import com.example.lazycoder.health.ModelClass.Item;
import com.example.lazycoder.health.R;
import com.example.lazycoder.health.adapter.ItemAdapter;
import com.example.lazycoder.health.databinding.FragmentAccessoriseBinding;
import com.example.lazycoder.health.databinding.FragmentDoctorBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Accessorise extends Fragment {

    private FragmentAccessoriseBinding binding;
    private List<Item> accessorises;
    private Context context;
    private ProductDatabase productDatabase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_accessorise, container, false);
        initializeAll();
        return binding.getRoot();
    }

    private void initializeAll() {
        accessorises = new ArrayList<>();
        productDatabase = new ProductDatabase(context);
        accessorises = productDatabase.getAllProduct("fitness");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.accessoriesRecyclerView.setHasFixedSize(true);
        binding.accessoriesRecyclerView.setLayoutManager(new GridLayoutManager(context,2));

        ItemAdapter adapter = new ItemAdapter(accessorises,context);
        binding.accessoriesRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

}
