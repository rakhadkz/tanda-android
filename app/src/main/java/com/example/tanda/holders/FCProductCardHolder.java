package com.example.tanda.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;

public class FCProductCardHolder extends RecyclerView.ViewHolder {
    public ImageView image;
    public TextView name;
    public RecyclerView recycler;
    public FCProductCardHolder(@NonNull View itemView) {
        super(itemView);
        this.image = itemView.findViewById(R.id.fc_product_image);
        this.name = itemView.findViewById(R.id.fc_product_name);
        this.recycler = itemView.findViewById(R.id.fc_product_quantity_recycler);
    }
}
