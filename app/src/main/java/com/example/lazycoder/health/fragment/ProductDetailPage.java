package com.example.lazycoder.health.fragment;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lazycoder.health.Database.ProductDatabase;
import com.example.lazycoder.health.ModelClass.ProductModel;
import com.example.lazycoder.health.R;
import com.example.lazycoder.health.databinding.FragmentProductDetailPageBinding;
import com.example.lazycoder.health.interfaces.ClickListener;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailPage extends Fragment {

    private FragmentProductDetailPageBinding binding;
    private Context context;
    private ClickListener clickListener;
    private ProductDatabase productDatabase;
    private String productCode;
    private ProductModel product;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        try {
            productCode = this.getArguments().getString("productCode");
        }catch (Exception e){
            productCode = "199";
            e.printStackTrace();
        }

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_product_detail_page, container, false);
        initializeAll();
        return binding.getRoot();
    }

    private void initializeAll() {
        clickListener = (ClickListener) context;
        productDatabase = new ProductDatabase(context);
        product = productDatabase.getProduct(productCode);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        binding.mapViewIv.setOnClickListener(mapViewListener);

        setDataToView();
    }

    View.OnClickListener mapViewListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Fragment fragment = new AddressMapView();
            clickListener.onProductClick(fragment);
        }
    };

    public void setDataToView(){
        Picasso.with(context).load(product.getImageUrl()).resize(400,400).into(binding.productImage);
        binding.productTitleTv.setText(product.getTitle());
        binding.productDescriptionTv.setText(product.getFullDescription());
        binding.shopNameTv.setText(product.getShopName());
        binding.stateTv.setText(product.getState());
        binding.addressTv.setText(product.getAddress());
        binding.postCodeTv.setText(product.getPostCode());
        binding.phoneTv.setText(product.getPhone());

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
