package com.example.tanda.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;

public class KeyValueHolder extends RecyclerView.ViewHolder {
    public TextView key, value;
    public KeyValueHolder(@NonNull View itemView) {
        super(itemView);
        this.key = itemView.findViewById(R.id.item_first_text);
        this.value = itemView.findViewById(R.id.item_second_text);
    }
}
