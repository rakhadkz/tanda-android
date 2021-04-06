package com.example.tanda;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder {

    ImageView image;
    TextView title, description, author, username;

    public MyHolder(@NonNull View itemView) {
        super(itemView);
        this.image = itemView.findViewById(R.id.item_image);
        this.title = itemView.findViewById(R.id.item_title);
        this.description = itemView.findViewById(R.id.item_description);
        this.author = itemView.findViewById(R.id.item_author);
        this.username = itemView.findViewById(R.id.item_username);
    }
}
