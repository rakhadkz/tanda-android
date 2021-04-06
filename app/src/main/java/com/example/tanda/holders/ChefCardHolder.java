package com.example.tanda.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;

public class ChefCardHolder extends RecyclerView.ViewHolder {
    public ImageView ava;
    public TextView fullName, price, rating;

    public ChefCardHolder(@NonNull View itemView) {
        super(itemView);
        this.ava = itemView.findViewById(R.id.chef_card_ava);
        this.fullName = itemView.findViewById(R.id.chef_card_full_name);
        this.price = itemView.findViewById(R.id.chef_card_price);
        this.rating = itemView.findViewById(R.id.chef_card_rating);
    }
}
