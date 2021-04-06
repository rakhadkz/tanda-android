package com.example.tanda.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;

public class RecipeCardHolder extends RecyclerView.ViewHolder {
    public ImageView image, author_ava;
    public TextView title, hash, author_full_name, author_city;

    public RecipeCardHolder(@NonNull View itemView) {
        super(itemView);
        this.image = itemView.findViewById(R.id.recipe_card_image);
        this.author_ava = itemView.findViewById(R.id.recipe_card_author_ava);
        this.title = itemView.findViewById(R.id.recipe_card_title);
        this.hash = itemView.findViewById(R.id.recipe_card_hash);
        this.author_full_name = itemView.findViewById(R.id.recipe_card_author_name);
        this.author_city = itemView.findViewById(R.id.recipe_card_author_city);
    }
}
