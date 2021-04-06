package com.example.tanda.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;

public class CollectionCardHolder extends RecyclerView.ViewHolder {
    public ImageView cover, shopImage;
    public TextView title, shopName, members;

    public CollectionCardHolder(@NonNull View itemView) {
        super(itemView);
        this.cover = itemView.findViewById(R.id.card_collection_cover);
        this.shopImage = itemView.findViewById(R.id.card_collection_shop_image);
        this.title = itemView.findViewById(R.id.card_collection_title);
        this.shopName = itemView.findViewById(R.id.card_collection_shop_name);
        this.members = itemView.findViewById(R.id.card_collection_members);
    }
}
