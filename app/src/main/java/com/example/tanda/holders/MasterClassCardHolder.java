package com.example.tanda.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;

public class MasterClassCardHolder extends RecyclerView.ViewHolder {
    public ImageView image;
    public TextView date, recipe, duration, requirements;
    public MasterClassCardHolder(@NonNull View itemView) {
        super(itemView);
        this.image = itemView.findViewById(R.id.chef_recipe_image);
        this.date = itemView.findViewById(R.id.card_masterclass_date);
        this.recipe = itemView.findViewById(R.id.card_masterclass_recipe_name);
        this.duration = itemView.findViewById(R.id.card_masterclass_duration);
        this.requirements = itemView.findViewById(R.id.card_masterclass_requirements);
    }
}
