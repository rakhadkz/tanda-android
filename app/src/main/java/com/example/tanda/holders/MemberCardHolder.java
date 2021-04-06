package com.example.tanda.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;

public class MemberCardHolder extends RecyclerView.ViewHolder {
    public ImageView ava;
    public TextView fullName, avaLetter;
    public MemberCardHolder(@NonNull View itemView) {
        super(itemView);
        this.ava = itemView.findViewById(R.id.card_member_ava);
        this.fullName = itemView.findViewById(R.id.card_member_name);
        this.avaLetter = itemView.findViewById(R.id.card_member_ava_letter);
    }
}
