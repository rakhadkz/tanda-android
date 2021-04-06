package com.example.tanda.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.DownloadImagesTask;
import com.example.tanda.R;
import com.example.tanda.holders.ShopCardHolder;
import com.example.tanda.models.ShopModel;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ShopCardAdapter extends RecyclerView.Adapter<ShopCardHolder> {
    Context context;
    ArrayList<ShopModel> list;

    public ShopCardAdapter(Context context, ArrayList<ShopModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ShopCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_shop, null);
        return new ShopCardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopCardHolder holder, int position) {
        final ShopModel shop = list.get(position);
        Picasso.get().load(shop.getImage()).networkPolicy(NetworkPolicy.OFFLINE).into(holder.image);


        holder.name.setText(shop.getName());
        holder.address.setText(shop.getAddress().getAddress());
    }

    public ShopModel getShop(int position){
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
