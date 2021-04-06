package com.example.tanda.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;

public class ShopCardHolder extends RecyclerView.ViewHolder {
    public ImageView image;
    public TextView name, address;
    public ShopCardHolder(@NonNull View itemView) {
        super(itemView);
        this.image = itemView.findViewById(R.id.card_shop_image);
        this.name = itemView.findViewById(R.id.card_shop_name);
        this.address = itemView.findViewById(R.id.card_shop_address);
    }
}
