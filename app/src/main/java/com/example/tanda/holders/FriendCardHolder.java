package com.example.tanda.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;

public class FriendCardHolder extends RecyclerView.ViewHolder {
    public ImageView ava, checked;
    public TextView name;
    public FriendCardHolder(@NonNull View itemView) {
        super(itemView);
        this.ava = itemView.findViewById(R.id.card_friend_ava);
        this.name = itemView.findViewById(R.id.card_friend_name);
        this.checked = itemView.findViewById(R.id.card_friend_checked);
    }
}
