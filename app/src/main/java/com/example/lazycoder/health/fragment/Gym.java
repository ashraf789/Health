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

import com.example.lazycoder.health.ModelClass.Item;
import com.example.lazycoder.health.R;
import com.example.lazycoder.health.adapter.ItemAdapter;
import com.example.lazycoder.health.databinding.FragmentGymBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Gym extends Fragment {


    private FragmentGymBinding binding;
    private List<Item> gyms;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_gym, container, false);
        initializeAll();
        return binding.getRoot();
    }

    private void initializeAll() {
        gyms = new ArrayList<>();
        Item gym;
        //sample product
        for (int  i = 0; i< 6; i++){
            gym = new Item(
                    "Gym No "+(1+i),
                    "Surgery",
                    "Apollo Hospital,Dhanmondi 32",
                    R.drawable.gymcenter
            );

            gyms.add(gym);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.gymRecyclerView.setHasFixedSize(true);
        binding.gymRecyclerView.setLayoutManager(new GridLayoutManager(context,2));

        ItemAdapter adapter = new ItemAdapter(gyms,context);
        binding.gymRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

}
