package com.example.tanda.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;
import com.squareup.picasso.Target;

public class RecipeCategoryCardHolder extends RecyclerView.ViewHolder {
    public ImageView image;
    public TextView title, count;
    public RecipeCategoryCardHolder(@NonNull View itemView) {
        super(itemView);
        this.image = itemView.findViewById(R.id.category_card_image);
        this.title = itemView.findViewById(R.id.category_card_title);
        this.count = itemView.findViewById(R.id.category_card_count);
    }
}
