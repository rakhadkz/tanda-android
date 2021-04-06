package com.example.tanda.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShopProductsHolder extends RecyclerView.ViewHolder {
    public ImageView shopImage;
    public TextView shopName, shopAddress;
    public ShopProductsHolder(@NonNull View itemView) {
        super(itemView);

    }
}
