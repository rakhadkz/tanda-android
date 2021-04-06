package com.example.tanda.holders;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;

public class CoverCardHolder extends RecyclerView.ViewHolder {
    public ImageView cover, checked;
    public CoverCardHolder(@NonNull View itemView) {
        super(itemView);
        this.cover = itemView.findViewById(R.id.card_cover);
        this.checked = itemView.findViewById(R.id.card_cover_checked);
    }
}
