package com.example.lazycoder.health.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lazycoder.health.ModelClass.Item;
import com.example.lazycoder.health.R;
import com.example.lazycoder.health.interfaces.ClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lazycoder on 2/8/18.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> products;
    private Context context;
    private ClickListener productClick;
    private Item product;


    public ItemAdapter(List<Item> products, Context context) {
        this.products = products;
        this.context = context;
        this.productClick = (ClickListener) context;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {
        product = products.get(position);
        holder.titleTv.setText(product.getTitle());
        holder.descTv.setText(product.getDescription());
        holder.locationTv.setText(product.getLocation());

        //Picasso is faster also it handle image outOfBound Memory Exception
        Picasso.with(context).load(product.getImageUrl()).resize(400,400).into(holder.productIV);

        holder.productRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productClick.onProductClick(product.getProductCode());
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTv;
        private TextView descTv;
        private TextView locationTv;
        private ImageView productIV;
        private RelativeLayout productRl;


        public ViewHolder(View itemView) {
            super(itemView);

            titleTv = itemView.findViewById(R.id.titleTv);
            descTv = itemView.findViewById(R.id.descTv);
            locationTv = itemView.findViewById(R.id.locationTv);
            productIV = itemView.findViewById(R.id.productIV);
            productRl = itemView.findViewById(R.id.productRl);

        }
    }
}
