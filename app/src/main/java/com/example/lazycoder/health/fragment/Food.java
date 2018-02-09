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
import com.example.lazycoder.health.databinding.FragmentFoodBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Food extends Fragment {


    private FragmentFoodBinding binding;
    private List<Item> foods;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_food, container, false);
        initializeAll();
        return binding.getRoot();
    }

    private void initializeAll() {
        foods = new ArrayList<>();
        Item food;
        //sample product
        for (int  i = 0; i< 6; i++){
            food = new Item(
                    "Food No "+(1+i),
                    "Surgery",
                    "Apollo Hospital,Dhanmondi 32",
                    R.drawable.honey
            );

            foods.add(food);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.foodRecyclerView.setHasFixedSize(true);
        binding.foodRecyclerView.setLayoutManager(new GridLayoutManager(context,2));

        ItemAdapter adapter = new ItemAdapter(foods,context);
        binding.foodRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

}
